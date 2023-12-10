package com.shamil.rmp.android.rooom2

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.DeleteTable
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import java.util.UUID

@Dao
interface PeopleDAO{
    @Query("select * from people")
    fun getPeoples(): Flow<List<People>>

    @Query("select * from people where id=(:id)")
    fun getPeople(id: UUID):Flow<People?>

//    @Query("select * from people")
//    fun getPeoples():LiveData<List<People>>
//
//    @Query("select * from people where id=(:id)")
//    fun getPeople(id: UUID):LiveData<People?>

    @Update
    fun updatePeople(people:People)

    @Query("select count(*) from people")
    fun countPeoples(): Flow<Int>

//    @Query("select count(*) from people")
//    fun countPeoples(): LiveData<Int>

    @Insert
    fun addPeople(people:People)

    @Delete
    fun delete(people: People)

}