package com.istianto.hellohappyfood

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Recipes(
    var title: String = "",
    var bahan: String = "",
    var buat: String = "",
    var images: Int = 0
) : Parcelable