package com.example.fifthmfirsthmcounter.presenter

import com.example.fifthmfirsthmcounter.Injector
import com.example.fifthmfirsthmcounter.view.CounterView

class Presenter {

    private val model = Injector.getModel()
    lateinit var view: CounterView

    fun increment() {
        model.increment()
        view.upDataCount(model.getCount())
        when {
            model.getCount() == 10 -> {
                view.showToastPlusTen()
            }
            model.getCount() == -5 -> {
                view.showToastMinusFive()
            }
            model.getCount() == 15 -> {
                view.textColor()
            }
            model.getCount() != 15 ->{
                view.defaultTextColor()
            }
        }
    }

    fun decrement() {
        model.decrement()
        view.upDataCount(model.getCount())
        when {
            model.getCount() == -5 -> {
                view.showToastMinusFive()
            }
            model.getCount() == 10 -> {
                view.showToastPlusTen()
            }
            model.getCount() == 15 -> {
                view.textColor()
            }
            model.getCount() != 15 ->{
                view.defaultTextColor()
            }
        }
    }

    fun attachView(view: CounterView) {
        this.view = view
    }
}