package com.example.practical2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.practical2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    private val myName2:MyName=MyName("BAIT")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.myName1=myName2
        binding.DoneButton.setOnClickListener{addNickname(it)}
        binding.nicknameText.setOnClickListener { updateNickname(it) }
      //  setContentView(R.layout.activity_main) when binding object no need this


        findViewById<Button>(R.id.Done_button).setOnClickListener()
        {
            addNickname(it)
        }
        findViewById<TextView>(R.id.nickname_text).setOnClickListener {
            updateNickname(it)
        }
    }

    private fun addNickname(view: View)
    {
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val nicknameText =findViewById<TextView>(R.id.nickname_text)

      //  binding.nicknameText.text=binding.nicknameEdit.text.toString()
      //  binding.nicknameEdit.visibility=View.GONE
      //  binding.DoneButton.visibility=View.GONE
      //  binding.nicknameText.visibility=View.VISIBLE

        binding.apply {
            myName1?.nickname = nicknameEdit.text.toString()
            invalidateAll()
        //    nicknameText.text=nicknameEdit.text.toString() //manipulate view not data
           // Log.i("MyName", myName1.name + "" + myName1.nickname)
           nicknameEdit.visibility=View.GONE
            DoneButton.visibility=View.GONE
           nicknameText.visibility=View.VISIBLE 
        }

        nicknameText.text = editText.text
        editText.visibility = View.GONE
        view.visibility = View.GONE
        nicknameText.visibility = View.VISIBLE

        //Hide the keyboard
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickname(view: View)
    {


        val editText = findViewById<EditText>(R.id.nickname_edit)
        val nicknameText =findViewById<TextView>(R.id.nickname_text)

        binding.apply {
            nicknameEdit.visibility = View.VISIBLE
           // editText.visibility = View.VISIBLE
          // view.visibility = View.VISIBLE
           nicknameText.visibility = View.GONE
            DoneButton.visibility=View.VISIBLE
        }


        //Hide the keyboard
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)

    }
}