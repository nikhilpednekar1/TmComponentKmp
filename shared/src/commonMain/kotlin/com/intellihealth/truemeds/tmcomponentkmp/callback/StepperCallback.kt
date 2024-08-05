package com.intellihealth.truemeds.tmcomponentkmp.callback

interface StepperCallback {
    fun cartItemPlus(qty: Int)
    fun cartItemMinus(qty: Int)
    fun stepperError(msg: String?)

    fun deleteAlert() {}

}