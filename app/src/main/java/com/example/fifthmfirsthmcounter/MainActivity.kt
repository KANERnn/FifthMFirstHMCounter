package com.example.fifthmfirsthmcounter

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.fifthmfirsthmcounter.databinding.ActivityMainBinding
import com.example.fifthmfirsthmcounter.presenter.Presenter
import com.example.fifthmfirsthmcounter.view.CounterView

class MainActivity : AppCompatActivity(),CounterView {

    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = Injector.getPresenter()
        presenter.attachView(this)
        initClickers()
    }

    private fun initClickers() {
        with(binding){
            btnIncrement.setOnClickListener {
                presenter.increment()
            }
            btnDecrement.setOnClickListener {
                presenter.decrement()
            }
        }
    }

    override fun upDataCount(count: Int) {
        binding.tvCounter.text = count.toString()
    }

    override fun showToastMinusFive() {
        this.showToast("Поздравляю -5")
    }

    override fun showToastPlusTen() {
        this.showToast("Поздравляю 10")
    }

    @SuppressLint("ResourceAsColor")
    override fun defaultTextColor() {
        binding.tvCounter.setTextColor(getColor(R.color.black))
    }

    @SuppressLint("ResourceAsColor")
    override fun textColor() {
        binding.tvCounter.setTextColor(getColor(R.color.green))
    }
}