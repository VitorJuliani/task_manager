package com.example.task_manager.user.model

enum class UserRole(isAdmin: Boolean) {
    USER(isAdmin = false), ADMIN(isAdmin = true)
}