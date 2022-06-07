package dev.dslam.merekeapp.presentation.fragments.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dev.dslam.merekeapp.databinding.FragmentAuthBinding

class AuthFragment : Fragment() {

    private var _binding: FragmentAuthBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAuthBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        handleUserAction()
    }

    private fun handleUserAction() {
        binding.signInButton.setOnClickListener {
            val action = AuthFragmentDirections.actionAuthFragmentToSignInFragment()
            this.findNavController().navigate(action)
        }

        binding.signUpTextView.setOnClickListener {
            val action = AuthFragmentDirections.actionAuthFragmentToSignUpActivity()
            this.findNavController().navigate(action)
        }
    }
}
