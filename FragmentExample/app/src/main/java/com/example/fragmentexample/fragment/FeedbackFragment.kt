package com.example.fragmentexample.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import com.example.fragmentexample.R
import com.example.fragmentexample.databinding.FragmentFeedbackBinding

class FeedbackFragment : Fragment() {
    private var onFeedbackSelectedListener: OnFeedbackSelectedListener? = null

    interface OnFeedbackSelectedListener {
        fun onFeedbackSelected(isLiked: Boolean)
    }

    val binding: FragmentFeedbackBinding by lazy {
        FragmentFeedbackBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            yesRadioButton.setOnClickListener {
                onFeedbackSelectedListener?.onFeedbackSelected(true)
            }

            noRadioButton.setOnClickListener {
                onFeedbackSelectedListener?.onFeedbackSelected(false)
            }
        }
    }

    fun setOnFeedbackSelectedListener(listener: OnFeedbackSelectedListener) {
        onFeedbackSelectedListener = listener
    }
}
