package dev.dslam.merekeapp.presentation.fragments.catalog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import dev.dslam.merekeapp.databinding.FragmentVenuesBinding
import dev.dslam.merekeapp.presentation.viewModels.VenuesFragmentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class VenuesFragment : Fragment() {

    private var _binding: FragmentVenuesBinding? = null
    private val binding
        get() = _binding!!

    private val venuesFragmentViewModel: VenuesFragmentViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVenuesBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeVenues()
    }

    private fun observeVenues() {
        venuesFragmentViewModel.newVenueList.observe(viewLifecycleOwner, { venueList ->
            if (!venueList.isNullOrEmpty()) {

            }
        })
    }
}
