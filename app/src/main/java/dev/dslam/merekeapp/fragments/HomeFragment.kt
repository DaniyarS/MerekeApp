package dev.dslam.merekeapp.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import dev.dslam.merekeapp.R
import dev.dslam.merekeapp.adapters.delegateAdapters.CategoryDelegateAdapter
import dev.dslam.merekeapp.adapters.delegateAdapters.SingerDelegateAdapter
import dev.dslam.merekeapp.adapters.delegateAdapters.VenueDelegateAdapter
import dev.dslam.merekeapp.adapters.composeAdapter.DelegateAdapterItem
import dev.dslam.merekeapp.models.Category
import dev.dslam.merekeapp.models.Status
import dev.dslam.merekeapp.models.adaptermodels.CategoryItem
import dev.dslam.merekeapp.models.adaptermodels.VenueItem
import dev.dslam.merekeapp.adapters.composeAdapter.CompositeAdapter
import dev.dslam.merekeapp.databinding.FragmentHomeBinding
import dev.dslam.merekeapp.models.Singer
import dev.dslam.merekeapp.models.Venue
import dev.dslam.merekeapp.models.adaptermodels.SingerItem
import dev.dslam.merekeapp.viewModels.HomeFragmentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding
        get() = _binding!!

    private val homeFragmentViewModel by viewModel<HomeFragmentViewModel>()

    private val list: MutableList<DelegateAdapterItem> = mutableListOf()

    private val categoryDelegateAdapter by lazy {
        CategoryDelegateAdapter(
            viewAllClickListener = {
                listener.onViewAllClicked(it)
            }
        )
    }

    private val singerDelegateAdapter by lazy {
        SingerDelegateAdapter(
            singerClickListener = {
                listener.onSingerSelected(it)
            }
        )
    }

    private val venueDelegateAdapter by lazy {
        VenueDelegateAdapter(
            venueClickListener = {
                listener.onVenueSelected(it)
            }
        )
    }

    private val compositeAdapter by lazy {
        CompositeAdapter
            .Builder()
            .add(singerDelegateAdapter)
            .add(categoryDelegateAdapter)
            .add(venueDelegateAdapter)
            .build()
    }

    private lateinit var listener: OnItemSelected

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnItemSelected) {
            listener = context
        } else {
            throw ClassCastException(
                "$context must implement OnItemSelected."
            )
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            homeFragmentList.apply {
                layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                adapter = compositeAdapter
            }
        }

        observeNewProducts(list)

        compositeAdapter.submitList(list)

        homeFragmentViewModel.loadingState.observe(this, {
            when(it.status) {
                Status.FAILED -> Toast.makeText(requireContext(), it.msg, Toast.LENGTH_SHORT).show()
                Status.RUNNING -> Toast.makeText(requireContext(), "Loading", Toast.LENGTH_SHORT).show()
                Status.SUCCESS -> Toast.makeText(requireContext(), "Success", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observeNewProducts(list: MutableList<DelegateAdapterItem>) {
        homeFragmentViewModel.newVenueList.observe(this, { venueList ->
            if (venueList != null) {
                val categoryItem = CategoryItem(Category(0, "Новые заведения"))
                list.add(categoryItem)
                list.add(VenueItem(venueList))
            }
        })

        homeFragmentViewModel.newSingersList.observe(this, { singerList ->
            if (singerList != null) {
                val categoryItem = CategoryItem(Category(2, "Новые артисты"))
                list.add(categoryItem)
                list.add(SingerItem(singerList))
            }
        })
    }

    interface OnItemSelected {
        fun onSingerSelected(singer: Singer)
        fun onVenueSelected(venue: Venue)
        fun onViewAllClicked(category: Category)
    }
}
