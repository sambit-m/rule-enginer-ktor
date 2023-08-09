package com.example.dao

import org.ktorm.database.Database
import org.ktorm.logging.ConsoleLogger
import org.ktorm.logging.LogLevel


fun databaseFactory(): Database {
    val driverClassName = "com.mysql.cj.jdbc.Driver"
    val jdbcURL = "jdbc:mysql://localhost:3306/pos"
    return Database.connect(
        jdbcURL,
        driverClassName,
        user = "newuser",
        password = "password",
        logger = ConsoleLogger(threshold = LogLevel.INFO)
    )
}