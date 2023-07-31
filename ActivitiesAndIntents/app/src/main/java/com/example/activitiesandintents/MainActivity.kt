package com.example.activitiesandintents

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle("Two Activities")

        val mReply = findViewById<TextView>(R.id.tv_reply)
        val mEdtMessage = findViewById<EditText>(R.id.edt_message)
        val mBtnSend = findViewById<Button>(R.id.btn_send)

        mReply.text = getData()
        mBtnSend.setOnClickListener {
            val strMessage = mEdtMessage.text.toString()
            sendData(strMessage)
        }
    }

    fun getData(): String? {
        val bundle = intent.extras
        val message = bundle?.getString("reply")
        return message
    }


    fun sendData(strMessage: String) {
        val bundle = Bundle()
        bundle.putString("message", strMessage)
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }


}