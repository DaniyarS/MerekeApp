package dev.dslam.merekeapp.presentation.fragments.catalog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import dev.dslam.merekeapp.databinding.FragmentSingersBinding
import dev.dslam.merekeapp.models.Status
import dev.dslam.merekeapp.presentation.adapters.catalogAdapters.PersonCatalogAdapter
import dev.dslam.merekeapp.presentation.viewModels.SingersFragmentViewModel
import dev.dslam.merekeapp.utils.EqualSpacingItemDecoration
import dev.dslam.merekeapp.utils.dp
import org.koin.androidx.viewmodel.ext.android.viewModel

class SingersFragment : Fragment() {

    private var _binding: FragmentSingersBinding? = null
    private val binding
        get() = _binding!!
    private val singersAdapter = PersonCatalogAdapter()
    private val viewModel: SingersFragmentViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSingersBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        observeSingers()
        viewModel.loadingState.observe(viewLifecycleOwner) {
            when (it.status) {
                Status.RUNNING -> {
                    binding.progressBar.isVisible = true
                }
                Status.SUCCESS -> {
                    binding.progressBar.isVisible = false
                }
                Status.FAILED -> {
                    binding.progressBar.isVisible = false
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupViews() = with(binding) {
        singersList.layoutManager =
            GridLayoutManager(requireContext(), 2)
        singersList.adapter = singersAdapter
        singersList.addItemDecoration(
            EqualSpacingItemDecoration(
                16.dp,
                EqualSpacingItemDecoration.GRID
            )
        )
    }

    private fun observeSingers() {
        viewModel.allSingersList.observe(viewLifecycleOwner) {
            if (!it.isNullOrEmpty()) {
                singersAdapter.submitList(it)
            }
        }
    }
}