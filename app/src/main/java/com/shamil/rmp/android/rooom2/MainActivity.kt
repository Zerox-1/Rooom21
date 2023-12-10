package com.shamil.rmp.android.rooom2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.room.DeleteTable
import com.shamil.rmp.android.rooom2.ui.theme.Rooom2Theme
import io.github.serpro69.kfaker.Faker


class MainActivity : ComponentActivity() {
    val viewModel:PeopleViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val faker=Faker()
        viewModel.addPeople(People(faker.name.firstName(),faker.internet.safeEmail()))
        setContent {
            val peoples =viewModel.peopleLD.collectAsState(null)
            Column {
                peoples.value?.forEach{
                    Text(text=it.name+" "+it.email, modifier = Modifier.clickable { viewModel.deletePeople(it) })
                }
            }
        }
    }
}


//class MainActivity : ComponentActivity() {
//    val viewModel:PeopleViewModel by viewModels()
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        var peoples= mutableStateListOf<People>()
//
//        val faker=Faker()
//        val add:()->Unit={
//            viewModel.addPeople(
//                People(faker.name.firstName(),
//                    faker.internet.safeEmail())
//            )
//        }
//        val deleteRandom:()->Unit={viewModel.deletePeople(viewModel.peopleLD.value!!.get(0))}
//        setContent {
//            viewModel.peopleLD.observe(this, Observer<List<People>>{
//                peoples.clear()
//                peoples.addAll(it)
//            })
//            showCities(peoples, add, deleteRandom)
//        }
//    }
//}
//@Composable
//fun showCities(peoples: MutableList<People>, onClick: () -> Unit, deleteRandom: () -> Unit) {
//    LazyColumn {
//        items(peoples) {
//            Text(text = it.name + " " + it.email)
//        }
//        item {
//            Button(onClick = onClick) {
//                Text("Add city")
//            }
//        }
//        item {
//            Button(onClick = deleteRandom) {
//                Text(text = "Delete random")
//            }
//        }
//    }
//}


//class MainActivity : ComponentActivity() {
//    val viewModel:PeopleViewModel by viewModels()
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        val faker= Faker()
//        viewModel.addPeople(People(faker.name.firstName(),faker.internet.safeEmail()))
//        setContent {
//            val peoples=viewModel.peopleLD.observeAsState()
//            Column {
//                peoples.value?.forEach{
//                    Text(text="people="+it.name+"  "+it.email)
//                }
//                Button(onClick = {viewModel.addPeople(People(faker.name.firstName(),faker.internet.safeEmail()))}) {
//                }
//            }
//        }
//    }
//}