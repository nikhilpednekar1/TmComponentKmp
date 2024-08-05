package com.intellihealth.truemeds.tmcomponentkmp.model

import com.intellihealth.truemeds.tmcomponentkmp.callback.FullWidthProductCardCallback
import com.intellihealth.truemeds.tmcomponentkmp.callback.StepperCallback
import com.intellihealth.truemeds.tmcomponentkmp.enums.FWPCWarningConstants
import com.intellihealth.truemeds.tmcomponentkmp.enums.StepperConstants


data class ProductInfoModel(
    //var cardType: FullWidthProductCardConstants? = null,
    var isReplaced: Boolean = false,
    var isOrgAddedToCart: Boolean = false,
    var isAutoReplaced: Boolean = false,
    var isSubsAddedToCart: Boolean = false,
    var product: Product = Product(),
    var suggestion: Product? = null,
    var isDisplayAddIcon: Boolean = false,
    var sameCompositionProduct: String = "",
    var sectionHeading:String?="",
    var itemClickPosition: Int = 0,
    var minDiscountValue:Float=0f
) {
    data class Product(
        val productCode: String = "",
        var skuName: String = "",
        var availabilityStatus: String? = null,
        var availabilityMessage: String? = null,
        var isAvailable: Boolean = true,
        var suppliedByTm: Boolean = true,
        var manufacturerName: String = "",
        var maxCappedQty: Int = 0,
        var mrp: Double = 0.0,
        var sellingPrice: Double = 0.0,
        var discount: Double = 0.0,
        var packSize: String = "",
        var unit: String = "",
        var packForm: String = "",
        var pricePerUnitLabel: String = "",
        var productImageUrl: String = "",
        var qty: Int? = 0,
        var composition: String = "",
        var subsSavingsPercentage: String? = null,

        var cxAcceptedSubs: Boolean = false,
        var switchBackSkuName: String? = null,
        var switchBackProductCode: String? = null,
        var switchBackImageUrl: String = "",
        var switchBackAvailability: Boolean = false,
        var preSubsSkuName: String = "",
        var preSubsProductCode: String = "",
        var prevSubsAvailabilityMessage: String = "",
        var usersAlsoBoughtMessage: String? = "",

        var subsFound: Boolean = false,
        var showStepper: Boolean = true,

        var callback: StepperCallback? = null,
        var productCallback: FullWidthProductCardCallback? = null,
        var stepperType: StepperConstants = StepperConstants.REGULAR,
        var priceInfo: List<PriceInfo>? = emptyList(),
        var showRemove:Boolean?=false,
        var showRemoved:Boolean?=false,
        var manufacturerAddress: String?="",
        var showSavingTitleIcon: Boolean = true,
        var availabilityStatusWarning: FWPCWarningConstants? = FWPCWarningConstants.WARNING_SAVIOUR,
        var productDetailsId: Long? = 0,
        val prevOrderId: Long? = 0,
        val prevOrgProductId: Long? = 0,
        var replacedSavingPercentage: Double? = 0.0,
        var recommendedQty: Int? = 1,
        var isOtc:Boolean?=false,
        var motherBrand:String?="",
        var isChronic:Boolean?=false,
        var drugType: String? = "",
    )
}

