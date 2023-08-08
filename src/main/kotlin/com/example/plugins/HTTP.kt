package com.example.plugins

import com.example.dao.DatabaseFactory
import com.example.models.Rules
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.swagger.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.ktorm.dsl.*

fun Application.configureHTTP() {
    routing {
        swaggerUI(path = "openapi")
        route("/test", HttpMethod.Get){
            handle {
                val res = arrayListOf<String?>();
                DatabaseFactory.init().from(Rules).select(Rules.name).where { (Rules.id eq 1) }.forEach {row->
                    res.add(row[Rules.name])
                }
                call.respondText(res.toString())
            }
        }
    }
}
