package com.shamil.rmp.android.rooom2

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity
data class People(
    @PrimaryKey val id:UUID= UUID.randomUUID(),
    val name:String,var email:String
){
    constructor(name: String,email:String) :this(UUID.randomUUID(),name,email)
}