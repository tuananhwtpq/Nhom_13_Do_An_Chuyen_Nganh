package com.example.foodordering.data.models

data class TaiKhoanEntity(
    val taiKhoanID: Int,
    val hoTen: String,
    val email: String,
    val matKhau: String, // Lưu ý: Luôn mã hóa khi lưu trữ
    val soDienThoai: String,
    val diaChi: String?,
    val vaiTro: String // Ví dụ: "USER", "ADMIN"
)