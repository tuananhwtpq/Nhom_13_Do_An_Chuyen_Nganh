package com.yourcompany.foodordering.data.model

data class DonHangEntity(
    val donHangID: Int,
    val taiKhoanID: Int, // Foreign Key
    val ngayDat: Long, // Dùng kiểu Long để lưu timestamp
    val tongTien: Double,
    val diaChiGiaoHang: String,
    val ghiChu: String?,
    val trangThai: String // Ví dụ: "PENDING", "COMPLETED"
)