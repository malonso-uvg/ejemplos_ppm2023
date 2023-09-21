<?php
declare(strict_types=1);
use Firebase\JWT\JWT;
require_once('../vendor/autoload.php');
require_once('../config/connection.php');

//Recepcion de los valores en el cuerpo de la llamada post
// Retrieved from filtered POST data
$json = file_get_contents('php://input'); // Lee el JSON del cuerpo de la solicitud
$data = json_decode($json, true); // Decodifica el JSON en un array asociativo


$usuario = $data['username'];
$contrasena = $data['password'];

//Verifico si existe el usuario
$sql = "SELECT id, username FROM user WHERE username = '$usuario' AND password = MD5('$contrasena')";
$resultado = $conexion->query($sql);

//$hasValidCredentials = true;
$hasValidCredentials = $resultado->num_rows == 1;

// extract credentials from the request
if ($hasValidCredentials) {
    $secret_Key  = '68V0zWFrS72GbpPreidkQFLfj4v9m3Ti+DXc8OB0gcM=';
    $date   = new DateTimeImmutable();
    $expire_at     = $date->modify('+6 minutes')->getTimestamp();      // Add 60 seconds
    $domainName = "edu.uvg.loginapp";
    $username   = $usuario;
                                           

    // Create the token as an array
    $request_data = [
        'iat'  => $date->getTimestamp(),        // Issued at: time when the token was generated
        'iss'  => $domainName,                  // Issuer
        'nbf'  => $date->getTimestamp(),        // Not before
        'exp'  => $expire_at,                      // Expire
        'userName' => $username,                // User name
    ];
	
    // Encode the array to a JWT string.
	$token = JWT::encode(
        $request_data,      //Data to be encoded in the JWT
        $secret_Key, // The signing key
        'HS512'     // Algorithm used to sign the token, see https://tools.ietf.org/html/draft-ietf-jose-json-web-algorithms-40#section-3
    );
	
	//Guardando el token en la bdd para auto login
	$row = $resultado->fetch_assoc();
    $user_id = $row["id"];
	$expire_at_formatted = date('Y-m-d', $expire_at);
	$sql = "UPDATE user SET token = '$token', token_expiracy = '$expire_at_formatted' where id = $user_id";
    if ($conexion->query($sql) === TRUE) {
        echo $token;
    } else {
        echo "Error al actualizar el nuevo valor: " . $conn->error;
    }
	    
} else {
	echo "error_bad_credentials";
}
