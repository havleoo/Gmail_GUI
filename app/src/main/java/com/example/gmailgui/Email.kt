package com.example.gmailgui

data class Email(
    val subject: String,
    val sender: String,
    val preview: String,
    var isStarred: Boolean = false
)
