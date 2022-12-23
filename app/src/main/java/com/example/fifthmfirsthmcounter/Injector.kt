package com.example.fifthmfirsthmcounter

import com.example.fifthmfirsthmcounter.model.CounterModel
import com.example.fifthmfirsthmcounter.presenter.Presenter

class Injector {

    companion object{
        fun getPresenter(): Presenter{
            return Presenter()
        }
        fun getModel():CounterModel{
            return CounterModel()
        }
    }
}