package com.poc.noteappkmm.android.di

import android.app.Application
import com.poc.noteappkmm.data.local.DatabaseDriverFactory
import com.poc.noteappkmm.data.note.SqlDelightNoteDataSource
import com.poc.noteappkmm.database.NoteDatabase
import com.poc.noteappkmm.domain.note.NoteDataSource
import com.squareup.sqldelight.db.SqlDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSqlDriver(app: Application): SqlDriver {
        return DatabaseDriverFactory(app).createDriver()
    }

    @Provides
    @Singleton
    fun provideNoteDataSource(driver: SqlDriver): NoteDataSource {
        return SqlDelightNoteDataSource(NoteDatabase(driver))
    }
}