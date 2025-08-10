package com.yourcompany.foodordering.domain.controller

import com.yourcompany.foodordering.data.model.DonHangEntity

class DonHangController {
    // Dành cho Người dùng
    fun layLichSuDonHang(taiKhoanID: Int): List<DonHangEntity> { return emptyList() }

    // Dành cho Quản trị viên
    fun xemDonHangMoi(): List<DonHangEntity> { return emptyList() }
    fun capNhatTrangThaiDonHang(donHangID: Int, trangThaiMoi: String) { /* ... */ }
}