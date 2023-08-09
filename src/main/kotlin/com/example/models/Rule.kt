package com.example.models

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.datetime
import org.ktorm.schema.int
import org.ktorm.schema.varchar
import java.time.LocalDateTime


interface Rule : Entity<Rule> {
    val id: Int
    val type: String
    val mode: String
    val name: String
    val position: Int
    val stop: Int
    val start_at: LocalDateTime
    val end_at: LocalDateTime?
    val user_limit: Int?
    val device_limit: Int?
    val store_limit: Int?
    val total_limit: Int?
    val coupon_limit: Int?
    val description: String?
    val terms: String?
    val activates_at: LocalDateTime
    val status: Int
    val created_at: LocalDateTime
    val updated_at: LocalDateTime
}

object Rules : Table<Rule>("rules") {
    val id = int("id").primaryKey().bindTo { it.id }
    val type = varchar("type").bindTo { it.type }
    val mode = varchar("mode").bindTo { it.mode }
    val name = varchar("name").bindTo { it.name }
    val position = int("position").bindTo { it.position }
    val stop = int("stop").bindTo { it.stop }
    val start_at = datetime("start_at").bindTo { it.start_at }
    val end_at = datetime("end_at").bindTo { it.end_at }
    val user_limit = int("user_limit").bindTo { it.user_limit }
    val device_limit = int("device_limit").bindTo { it.device_limit }
    val store_limit = int("store_limit").bindTo { it.store_limit }
    val total_limit = int("total_limit").bindTo { it.total_limit }
    val coupon_limit = int("coupon_limit").bindTo { it.coupon_limit }
    val description = varchar("description").bindTo { it.description }
    val terms = varchar("terms").bindTo { it.terms }
    val activates_at = datetime("activates_at").bindTo { it.activates_at }
    val status = int("status").bindTo { it.status }
    val created_at = datetime("created_at").bindTo { it.created_at }
    val updated_at = datetime("updated_at").bindTo { it.updated_at }
}