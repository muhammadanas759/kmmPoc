package com.poc.noteappkmm.di

import com.poc.noteappkmm.data.local.DatabaseDriverFactory
import com.poc.noteappkmm.data.note.SqlDelightNoteDataSource
import com.poc.noteappkmm.database.NoteDatabase
import com.poc.noteappkmm.domain.note.NoteDataSource

class DatabaseModule {

    private val factory by lazy { DatabaseDriverFactory() }
    val noteDataSource: NoteDataSource by lazy {
        SqlDelightNoteDataSource(NoteDatabase(factory.createDriver()))
    }
}