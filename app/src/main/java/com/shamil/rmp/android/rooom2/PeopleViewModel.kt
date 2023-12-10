package com.shamil.rmp.android.rooom2

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow

class PeopleViewModel:ViewModel() {
    private val peopleRepository=PeopleRepository.get()
//    val peopleLD:LiveData<List<People>> = peopleRepository.getPeoples()
    val peopleLD: Flow<List<People>> = peopleRepository.getPeoples()

    fun addPeople(people: People){
        peopleRepository.addPeople(people)
    }
    fun deletePeople(t:People){
        peopleRepository.delete(t)
    }
}