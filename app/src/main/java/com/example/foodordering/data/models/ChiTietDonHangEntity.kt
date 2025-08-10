package com.yourcompany.foodordering.data.model

data class ChiTietDonHangEntity(
    val donHangID: Int, // Composite Primary Key 1, Foreign Key
    val monAnID: Int,   // Composite Primary Key 2, Foreign Key
    val soLuong: Int,
    val donGia: Double // Giá tại thời điểm đặt hàng
)