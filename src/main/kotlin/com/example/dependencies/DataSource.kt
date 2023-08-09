package com.example.dependencies

import com.example.dao.databaseFactory
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton
import org.ktorm.database.Database

val dataSource = DI {
    bind<Database> {
        singleton { databaseFactory() }
    }
}