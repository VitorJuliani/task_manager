package com.example.task_manager.datasource

import com.example.task_manager.app.AppProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
class DataSourceConfiguration {

    @Bean
    fun dataSource(appProperties: AppProperties): DataSource {
        val dataSource = DataSourceBuilder.create().apply {
            this.driverClassName(appProperties.dataSource.driverName)
            this.url(appProperties.dataSource.url)
            this.username(appProperties.dataSource.username)
            this.password(appProperties.dataSource.password)
        }

        return dataSource.build()
    }

}