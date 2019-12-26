package com.example.mvvc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //declare module-level variable
    private lateinit var countViewModel: CountViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MVVC","OnCreate")
        //initialize the ViewModel
        countViewModel  = ViewModelProviders.of(this).get(CountViewModel::class.java)
        textViewResult.text = countViewModel.count.value.toString()

        countViewModel.count.observe(
            this,
            Observer{
                if(it.equals(10)) goodLuck()
            }
        )
        buttonPlus.setOnClickListener{
            countViewModel.increment()
            textViewResult.text = countViewModel.count.value.toString()
        }
        buttonMinus.setOnClickListener{
            countViewModel.decrement()
            textViewResult.text = countViewModel.count.value.toString()
        }
    }

    private fun goodLuck() {
        Toast.makeText(this,"Good Luck!!",Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        Log.d("MVCC","OnDestroy")
        super.onDestroy()
    }
}
