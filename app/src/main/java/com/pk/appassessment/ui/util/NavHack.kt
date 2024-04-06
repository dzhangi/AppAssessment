package com.pk.appassessment.ui.util

fun String.sendLinkNavHack(): String {
    return this.replace("/", "|")
}

fun String.recieveLinkNavHack(): String {
    return this.replace("|", "/")
}