package com.example.task_manager.app

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "app")
data class AppProperties(
        val dataSource: DataSource
) {
    data class DataSource (
            val driverName: String,
            val url: String,
            val username: String,
            val password: String
    )
}