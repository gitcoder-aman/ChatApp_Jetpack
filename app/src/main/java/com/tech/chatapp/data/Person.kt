package com.tech.chatapp.data

import android.os.Parcelable
import androidx.annotation.DrawableRes
import com.tech.chatapp.R
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Person(
    val id: Int = 0,
    val name: String = "",
    @DrawableRes val icon: Int = R.drawable.person_1
) : Parcelable

val personList = listOf(
    Person(1, "Parnav", R.drawable.person_1),
    Person(2, "Ayesha", R.drawable.person_2),
    Person(3, "Roshini", R.drawable.person_3),
    Person(4, "Kaushik", R.drawable.person_4),
    Person(5, "Dad", R.drawable.person_5),
    Person(6, "Aman", R.drawable.person_6),

    Person(7, "Parnav", R.drawable.person_6),
    Person(8, "Ayesha", R.drawable.person_5),
    Person(9, "Roshini", R.drawable.person_4),
    Person(10, "Kaushik", R.drawable.person_3),
    Person(11, "Dad", R.drawable.person_2),
    Person(12, "Aman", R.drawable.person_1)
)