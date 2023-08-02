package com.example.activitiesandintents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.activitiesandintents.constant.Constants
import com.example.activitiesandintents.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setTitle(R.string.second_activity_title)

        binding.tvMessage.text = getData()
        binding.btnReply.setOnClickListener {
            val strReply = binding.edtReply.text.toString()
            sendData(strReply)
        }
    }

    fun getData(): String? {
        val bundle = intent.extras
        val message = bundle?.getString(Constants.MESSAGE_KEY)
        return message
    }

    fun sendData(strReply: String) {
        val bundle = Bundle()
        bundle.putString(Constants.REPLY_KEY, strReply)
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }
}