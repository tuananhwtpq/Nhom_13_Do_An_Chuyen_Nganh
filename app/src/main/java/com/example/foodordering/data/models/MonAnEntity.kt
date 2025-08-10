package com.yourcompany.foodordering.data.model

data class MonAnEntity(
    val monAnID: Int,
    val tenMon: String,
    val moTa: String?,
    val gia: Double,
    val hinhAnhURL: String?,
    val trangThai: String, // Ví dụ: "AVAILABLE", "UNAVAILABLE"
    val danhMucID: Int // Foreign Key
)