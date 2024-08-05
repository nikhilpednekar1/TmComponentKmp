package com.intellihealth.truemeds.tmcomponentkmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform