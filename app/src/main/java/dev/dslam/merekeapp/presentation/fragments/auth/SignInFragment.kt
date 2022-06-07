package dev.dslam.merekeapp.presentation.fragments.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import dev.dslam.merekeapp.FullScreenFragment
import dev.dslam.merekeapp.databinding.FragmentSignInBinding
import dev.dslam.merekeapp.presentation.viewModels.SignInAction
import dev.dslam.merekeapp.presentation.viewModels.SignInState
import dev.dslam.merekeapp.presentation.viewModels.SignInViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignInFragment : FullScreenFragment() {

    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!
    private val signInViewModel: SignInViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignInBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        handleSignIn()
        observeSignIn()
    }

    private fun handleSignIn() {
        binding.signInButton.setOnClickListener {
            with(binding) {
                if (!passwordTextView.text.isNullOrBlank() && !emailTextView.text.isNullOrBlank()) {
                    signInViewModel.dispatch(
                        SignInAction.SignIn(
                            email = emailTextView.text.toString(),
                            password = passwordTextView.text.toString()
                        )
                    )
                } else {
                    Toast.makeText(requireContext(), "Заполните поля", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun observeSignIn() {
        signInViewModel.state.observe(viewLifecycleOwner) { state ->
            when (state) {
                is SignInState.SignResponse -> {
                    signInViewModel.dispatch(SignInAction.SaveToken(state.token))
                }
                is SignInState.SignErrorResponse -> {
                    Toast.makeText(requireContext(), state.error, Toast.LENGTH_SHORT).show()
                }
                is SignInState.TokenSaved -> {
                    val action = SignInFragmentDirections.actionSignInFragmentToMainActivity()
                    this.findNavController().navigate(action)
                }
            }
        }
    }
}