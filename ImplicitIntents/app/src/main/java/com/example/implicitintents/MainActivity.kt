package com.example.implicitintents

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val openWebButton = findViewById<Button>(R.id.openWebButton)
        val openMapButton = findViewById<Button>(R.id.openMapButton)
        val shareTextButton = findViewById<Button>(R.id.shareTextButton)
        val webUrlEditText = findViewById<EditText>(R.id.webUrlEditText)
        val mapLocationEditText = findViewById<EditText>(R.id.mapLocationEditText)
        val shareTextEditText = findViewById<EditText>(R.id.shareTextEditText)

        openWebButton.setOnClickListener {
            val url = webUrlEditText.text.toString()
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        openMapButton.setOnClickListener {
            val location = mapLocationEditText.text.toString()
            val uri = "geo:$location"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
            startActivity(intent)
        }

        shareTextButton.setOnClickListener {
            val text = shareTextEditText.text.toString()
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, text)
            startActivity(Intent.createChooser(intent, "Chia sẻ với"))
        }
    }
}