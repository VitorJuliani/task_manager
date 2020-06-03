package com.example.task_manager.security

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import javax.sql.DataSource

@EnableWebSecurity
class SecurityConfiguration(private val dataSource: DataSource,
                            private val passwordEncoder: BCryptPasswordEncoder) : WebSecurityConfigurerAdapter() {

    companion object {
        private const val FIND_USER_QUERY = "SELECT email, password, enabled FROM users WHERE email = ?"
        private const val FIND_USER_AUTHORITIES = "SELECT users.email, authorities.authority FROM authorities, users WHERE users.email = ?"
    }

    override fun configure(http: HttpSecurity) {
        http.csrf().disable()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and().formLogin()
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(FIND_USER_QUERY)
                .authoritiesByUsernameQuery(FIND_USER_AUTHORITIES)
                .passwordEncoder(passwordEncoder)
    }
}