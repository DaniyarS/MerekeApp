package dev.dslam.merekeapp.presentation.fragments.catalog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import dev.dslam.merekeapp.databinding.FragmentDancersBinding
import dev.dslam.merekeapp.models.Status
import dev.dslam.merekeapp.presentation.adapters.catalogAdapters.PersonCatalogAdapter
import dev.dslam.merekeapp.presentation.viewModels.DancersFragmentViewModel
import dev.dslam.merekeapp.utils.EqualSpacingItemDecoration
import dev.dslam.merekeapp.utils.dp
import org.koin.androidx.viewmodel.ext.android.viewModel

class DancersFragment : Fragment() {
    private var _binding: FragmentDancersBinding? = null
    private val binding
        get() = _binding!!
    private val viewModel: DancersFragmentViewModel by viewModel()
    private val dancersAdapter = PersonCatalogAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDancersBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        observeDancers()
        viewModel.loadingState.observe(viewLifecycleOwner) {
            when (it.status) {
                Status.RUNNING -> {
                    Toast.makeText(requireContext(), "Loading", Toast.LENGTH_SHORT)
                        .show()
                    binding.progressBar.isVisible = true
                }
                Status.SUCCESS -> {
                    Toast.makeText(requireContext(), "Success", Toast.LENGTH_SHORT)
                        .show()
                    binding.progressBar.isVisible = false
                }
                Status.FAILED -> {
                    Toast.makeText(requireContext(), it.msg, Toast.LENGTH_SHORT).show()
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
        showmansList.layoutManager =
            GridLayoutManager(requireContext(), 2)
        showmansList.adapter = dancersAdapter
        showmansList.addItemDecoration(
            EqualSpacingItemDecoration(
                16.dp,
                EqualSpacingItemDecoration.GRID
            )
        )
    }

    private fun observeDancers() {
        viewModel.allDancersList.observe(viewLifecycleOwner) {
            if (!it.isNullOrEmpty()) {
                dancersAdapter.submitList(it)
            }
        }
    }
}