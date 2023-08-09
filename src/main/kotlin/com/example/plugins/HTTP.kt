package com.example.plugins

import com.example.dependencies.dataSource
import com.example.models.Rules
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.swagger.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.kodein.di.instance
import org.ktorm.database.Database
import org.ktorm.dsl.*

fun Application.configureHTTP() {
    routing {
        swaggerUI(path = "openapi")
        route("/test", HttpMethod.Get) {
            handle {
                val res = arrayListOf<String?>();
                val db: Database by dataSource.instance()
                db.from(Rules).select().where { (Rules.id eq 1) }.forEach { row ->
                    res.add(row[Rules.name])
                    res.add(row[Rules.description])
                }
                call.respondText(res.toString())
            }
        }
    }
}
