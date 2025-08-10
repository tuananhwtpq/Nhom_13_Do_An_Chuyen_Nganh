package com.yourcompany.foodordering.domain.controller

import com.yourcompany.foodordering.data.model.MonAnEntity

class ThucDonController {
    // Dành cho Quản trị viên
    fun themMonAn(monAn: MonAnEntity) { /* ... */ }
    fun suaMonAn(monAnID: Int, thongTinMoi: MonAnEntity) { /* ... */ }
    fun xoaMonAn(monAnID: Int) { /* ... */ }
    fun quanLyDanhMuc() { /* ... */ }
}