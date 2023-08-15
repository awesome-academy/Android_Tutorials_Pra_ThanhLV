package com.example.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.activities.constant.Constants
import com.example.activities.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setTitle(R.string.main_activity_title)

        binding.tvReply.text = getData()
        binding.btnSend.setOnClickListener {
            val strMessage = binding.edtMessage.text.toString()
            sendData(strMessage)
        }
    }

    fun getData(): String? {
        val bundle = intent.extras
        val message = bundle?.getString(Constants.REPLY_KEY)
        return message
    }


    fun sendData(strMessage: String) {
        val bundle = Bundle()
        bundle.putString(Constants.MESSAGE_KEY, strMessage)
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }

}
