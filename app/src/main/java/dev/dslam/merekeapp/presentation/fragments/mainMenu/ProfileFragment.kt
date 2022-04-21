package dev.dslam.merekeapp.presentation.fragments.mainMenu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import dev.dslam.merekeapp.databinding.FragmentProfileBinding
import dev.dslam.merekeapp.presentation.adapters.UserMenuListAdapter
import dev.dslam.merekeapp.presentation.viewModels.ProfileFragmentViewModel
import dev.dslam.merekeapp.presentation.viewModels.ProfileState
import dev.dslam.merekeapp.utils.EqualSpacingItemDecoration
import dev.dslam.merekeapp.utils.dp
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private val profileFragmentViewModel: ProfileFragmentViewModel by viewModel()
    private val userMenuListAdapter = UserMenuListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        configureObservers()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupViews() = with(binding.profileItemsList) {
        layoutManager =
            GridLayoutManager(requireContext(), 2)
        adapter = userMenuListAdapter
        addItemDecoration(
            EqualSpacingItemDecoration(
                16.dp,
                EqualSpacingItemDecoration.GRID
            )
        )
    }

    private fun configureObservers() {
        profileFragmentViewModel.state.observe(viewLifecycleOwner) { state ->
            when(state) {
                is ProfileState.ShowUserMenu -> {
                    userMenuListAdapter.submitList(state.userMenuList)
                }
            }
        }
    }
}
