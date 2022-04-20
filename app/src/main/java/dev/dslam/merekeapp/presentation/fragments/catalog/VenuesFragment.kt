package dev.dslam.merekeapp.presentation.fragments.catalog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import dev.dslam.merekeapp.databinding.FragmentVenuesBinding
import dev.dslam.merekeapp.models.Status
import dev.dslam.merekeapp.presentation.adapters.catalogAdapters.VenueCatalogAdapter
import dev.dslam.merekeapp.presentation.viewModels.VenuesFragmentViewModel
import dev.dslam.merekeapp.utils.EqualSpacingItemDecoration
import dev.dslam.merekeapp.utils.dp
import org.koin.androidx.viewmodel.ext.android.viewModel

class VenuesFragment : Fragment() {

    private var _binding: FragmentVenuesBinding? = null
    private val binding
        get() = _binding!!

    private val viewModel: VenuesFragmentViewModel by viewModel()
    private val venuesAdapter = VenueCatalogAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVenuesBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        observeVenues()
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

    private fun setupViews() = with(binding) {
        venuesList.layoutManager =
            GridLayoutManager(requireContext(), 2)
        venuesList.adapter = venuesAdapter
        venuesList.addItemDecoration(
            EqualSpacingItemDecoration(
                16.dp,
                EqualSpacingItemDecoration.GRID
            )
        )
    }

    private fun observeVenues() {
        viewModel.allVenueList.observe(viewLifecycleOwner, {
            if (!it.isNullOrEmpty()) {
                venuesAdapter.submitList(it)
            }
        })
    }
}
