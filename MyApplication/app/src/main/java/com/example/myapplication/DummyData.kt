package com.example.myapplication

data class DummyData(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)