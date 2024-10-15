package com.example.lab2.ui.newfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.lab2.databinding.FragmentHomeBinding
import com.example.lab2.databinding.FragmentNewBinding

class NewFragment : Fragment() {

    private var _binding: FragmentNewBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val newViewModel =
            ViewModelProvider(this).get(NewViewModel::class.java)

        _binding = FragmentNewBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textNew
        newViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}