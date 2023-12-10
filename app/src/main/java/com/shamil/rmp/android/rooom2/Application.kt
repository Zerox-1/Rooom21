package com.shamil.rmp.android.rooom2

import android.app.Application

class PeopleApp:Application(){
    override fun onCreate() {
        super.onCreate()
        PeopleRepository.initialize(this)
    }
}