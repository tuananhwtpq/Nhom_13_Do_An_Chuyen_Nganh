package com.yourcompany.foodordering.domain.controller

import com.example.foodordering.data.models.TaiKhoanEntity


class DangKyController {
    fun xulyDangKy(thongTin: TaiKhoanEntity): Boolean {
        // TODO: Implement logic to validate info and save to database
        println("Xử lý đăng ký cho: ${thongTin.email}")
        return true
    }
}