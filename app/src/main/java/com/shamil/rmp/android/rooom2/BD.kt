package com.shamil.rmp.android.rooom2

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [People::class], version = 1)
abstract class PeopleDatabase:RoomDatabase(){
    abstract fun PeopleDao():PeopleDAO
}