package com.example.dependencyinjectionexample

import dagger.Module
import dagger.hilt.InstallIn
import dagger.Provides
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    @Named("test1")
    fun testString1() = "This is a test string"

    @Singleton
    @Provides
    @Named("test2")
    fun testString2() = "This is another test string"
}