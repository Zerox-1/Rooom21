package com.shamil.rmp.android.rooom2

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import kotlinx.coroutines.flow.Flow
import java.lang.IllegalStateException
import java.util.UUID
import java.util.concurrent.Executors

private const val DB="people"

class PeopleRepository private constructor(context: Context){
    private val db:PeopleDatabase= Room.databaseBuilder(context.applicationContext,PeopleDatabase::class.java,DB).build()
    private val peopleDAO:PeopleDAO=db.PeopleDao()
    private val executor= Executors.newSingleThreadExecutor()
//    fun getPeoples():LiveData<List<People>> = peopleDAO.getPeoples()
//    fun getPeople(id: UUID):LiveData<People?> = peopleDAO.getPeople(id)
//    fun countPeoples():LiveData<Int> = peopleDAO.countPeoples()
    fun getPeoples(): Flow<List<People>> = peopleDAO.getPeoples()
    fun getPeople(id: UUID):Flow<People?> = peopleDAO.getPeople(id)
    fun countPeoples(): Flow<Int> = peopleDAO.countPeoples()

    fun addPeople(city:People){
        executor.execute{
            peopleDAO.addPeople(city)
        }
    }

    fun delete(city:People){
        executor.execute{
            peopleDAO.delete(city)
        }
    }

    companion object{
        private var INSTANCE:PeopleRepository?=null
        fun initialize(context: Context){
            if(INSTANCE==null){
                INSTANCE=PeopleRepository(context = context)
            }
        }
        fun get():PeopleRepository{
            return INSTANCE?:
            throw IllegalStateException("not initialized")
        }
    }
}