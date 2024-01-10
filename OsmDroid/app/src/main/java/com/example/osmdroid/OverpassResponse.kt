package com.example.osmdroid

data class OverpassResponse(
    val elements: List<Element>
)

data class Element(
    val type: String,
    val lat: Double,
    val lon: Double
)
