package com.intellihealth.truemeds.tmcomponentkmp.callback

interface FullWidthProductCardCallback {
    fun removeButtonClick(productCode:String)
    fun removeButtonSubsClick(productCode:String) {}
    fun switchBackOrg(productCode:String,switchBackAvailability:Boolean)
    fun substituteCheck(productCode:String)
    fun productClick(productCode:String){}
    fun suggestionClick(productCode:String){}
    fun prevSubsAvailabilityMessageClick(productCode:String){}
}