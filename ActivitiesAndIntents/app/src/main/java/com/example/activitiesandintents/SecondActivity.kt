package com.example.activitiesandintents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        setTitle("Second Activities")

        val mMessage = findViewById<TextView>(R.id.tv_message)
        val mEdtReply = findViewById<EditText>(R.id.edt_reply)
        val mBtnReply = findViewById<Button>(R.id.btn_reply)

        mMessage.text = getData()
        mBtnReply.setOnClickListener{
            val strReply = mEdtReply.text.toString()
            sendData(strReply)
        }
    }

    fun getData(): String? {
        val bundle = intent.extras
        val message = bundle?.getString("message")
        return message
    }

    fun sendData(strReply: String) {
        val bundle = Bundle()
        bundle.putString("reply", strReply)
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }
}