package com.example.composemeal.data

data class Recipe(
    val title: String,
    val calories: Int,
    val ingredients: List<String>
)