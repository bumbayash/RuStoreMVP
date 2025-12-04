package com.nikita.rustoremvp.data.models

// ВРЕМЕННО используй String вместо enum для простоты
data class App(
    val id: String,
    val name: String,
    val developer: String,
    val icon: Int,
    val category: String,      // ← String, не enum Category
    val ageRating: String,     // ← String, не enum AgeRating
    val shortDescription: String,
    val fullDescription: String,
    val screenshots: List<Int>
)