package com.example.fragmentexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.fragmentexample.databinding.ActivityMainBinding
import com.example.fragmentexample.fragment.FeedbackFragment

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val feedbackFragment = FeedbackFragment()

        supportFragmentManager.beginTransaction()
            .add(binding.fragmentContainer.id, feedbackFragment).commit()

        feedbackFragment.setOnFeedbackSelectedListener(object :
            FeedbackFragment.OnFeedbackSelectedListener {
            override fun onFeedbackSelected(isLiked: Boolean) {
                val fragment = supportFragmentManager.findFragmentById(binding.fragmentContainer.id)

                if (fragment is FeedbackFragment) {
                    fragment.binding.responseTextView.text = getString(
                        if (isLiked) R.string.article_like
                        else R.string.article_thanks
                    )
                }
            }
        })
    }
}
