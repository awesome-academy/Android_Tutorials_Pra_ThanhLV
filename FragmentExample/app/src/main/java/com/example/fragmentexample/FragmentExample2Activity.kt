package com.example.fragmentexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.fragmentexample.databinding.ActivityFragmentExample2Binding
import com.example.fragmentexample.databinding.ActivityMainBinding
import com.example.fragmentexample.fragment.FeedbackFragment

class FragmentExample2Activity : AppCompatActivity() {

    private val binding by lazy {
        ActivityFragmentExample2Binding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnControl.setOnClickListener {
            if (binding.btnControl.text.equals(getString(R.string.open))) {
                val feedbackFragment = FeedbackFragment()
                supportFragmentManager.beginTransaction()
                    .replace(binding.fragmentContainer.id, feedbackFragment)
                    .commit()
                feedbackFragment.setOnFeedbackSelectedListener(object :
                    FeedbackFragment.OnFeedbackSelectedListener {
                    override fun onFeedbackSelected(isLiked: Boolean) {
                        val fragment =
                            supportFragmentManager.findFragmentById(binding.fragmentContainer.id)
                        if (fragment is FeedbackFragment) {
                            fragment.binding.responseTextView.text = getString(
                                if (isLiked) R.string.article_like
                                else R.string.article_thanks
                            )
                        }
                    }
                })
                binding.btnControl.text = getString(R.string.close)
            } else if (binding.btnControl.text.equals(getString(R.string.close))) {
                val feedbackFragment =
                    supportFragmentManager.findFragmentById(binding.fragmentContainer.id)
                if (feedbackFragment != null) {
                    supportFragmentManager.beginTransaction()
                        .remove(feedbackFragment)
                        .commit()
                }
                binding.btnControl.text = getString(R.string.open)
            }

        }
    }
}
