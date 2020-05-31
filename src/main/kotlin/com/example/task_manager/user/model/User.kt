package com.example.task_manager.user.model

data class User(
        val id: Long,
        val username: String,
        val email: String,
        val password: String,
        val photo: String,
        val role: UserRole
)