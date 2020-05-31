package com.example.task_manager.app.configuration

import com.example.task_manager.app.AppProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(AppProperties::class)
class AppPropertiesConfiguration {
}