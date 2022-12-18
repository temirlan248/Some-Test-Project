package kz.temir.sometestproject.domain.model

data class Task(
    val name: String,
    val description: String,
    val id: Int = 0,
)
