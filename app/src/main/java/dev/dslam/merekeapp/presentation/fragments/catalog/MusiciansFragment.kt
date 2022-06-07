package dev.dslam.merekeapp.presentation.fragments.catalog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import dev.dslam.merekeapp.databinding.FragmentMusiciansBinding
import dev.dslam.merekeapp.models.Status
import dev.dslam.merekeapp.presentation.adapters.catalogAdapters.PersonCatalogAdapter
import dev.dslam.merekeapp.presentation.viewModels.MusiciansFragmentViewModel
import dev.dslam.merekeapp.utils.EqualSpacingItemDecoration
import dev.dslam.merekeapp.utils.dp
import org.koin.androidx.viewmodel.ext.android.viewModel

class MusiciansFragment : Fragment() {
    private var _binding: FragmentMusiciansBinding? = null
    private val binding
        get() = _binding!!
    private val viewModel: MusiciansFragmentViewModel by viewModel()
    private val musiciansAdapter = PersonCatalogAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMusiciansBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        observeMusicians()
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
        showmansList.layoutManager =
            GridLayoutManager(requireContext(), 2)
        showmansList.adapter = musiciansAdapter
        showmansList.addItemDecoration(
            EqualSpacingItemDecoration(
                16.dp,
                EqualSpacingItemDecoration.GRID
            )
        )
    }

    private fun observeMusicians() {
        viewModel.allMusiciansList.observe(viewLifecycleOwner) {
            if (!it.isNullOrEmpty()) {
                musiciansAdapter.submitList(it)
            }
        }
    }
}
