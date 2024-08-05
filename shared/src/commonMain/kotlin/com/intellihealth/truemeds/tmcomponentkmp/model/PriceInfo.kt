package com.intellihealth.truemeds.tmcomponentkmp.model

data class PriceInfo(
    var mrp: Double = 0.0,
    var sellingPrice: Double = 0.0,
    var discount: Double = 0.0,
    var qty: Int = 0
)