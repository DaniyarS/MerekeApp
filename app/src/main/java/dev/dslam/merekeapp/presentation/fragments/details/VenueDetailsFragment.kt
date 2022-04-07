package dev.dslam.merekeapp.presentation.fragments.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import dev.dslam.merekeapp.R
import dev.dslam.merekeapp.adapters.ViewPagerAdapter
import dev.dslam.merekeapp.databinding.FragmentVenueDetailsBinding
import dev.dslam.merekeapp.models.Venue

class VenueDetailsFragment : Fragment(R.layout.fragment_venue_details) {

    private var _binding: FragmentVenueDetailsBinding? = null
    private val binding
        get() = _binding!!

    companion object {

        private const val VENUE_MODEL = "venue"

        fun newInstance(venue: Venue): VenueDetailsFragment {
            val args = Bundle()
            args.putParcelable(VENUE_MODEL, venue)
            val fragment = VenueDetailsFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentVenueDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPagerAdapter = activity?.supportFragmentManager?.let { ViewPagerAdapter(it) }

        if (arguments != null) {
            val venueModel = requireArguments().getParcelable<Venue>(VENUE_MODEL)
            venueModel?.images?.let { viewPagerAdapter?.setImages(it) }
            binding.productImageViewPager.adapter = viewPagerAdapter
            binding.tabLayout.setupWithViewPager(binding.productImageViewPager)
        } else {
            Toast.makeText(requireContext(), "Не удалось прогрузить данные", Toast.LENGTH_SHORT).show()
        }

        binding.backButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}