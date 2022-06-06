package dev.dslam.merekeapp.presentation.fragments.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.dslam.merekeapp.FullScreenFragment
import dev.dslam.merekeapp.databinding.FragmentSignUpBinding

class SignUpFragment : FullScreenFragment() {

    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignUpBinding.inflate(inflater)
        return binding.root
    }
}