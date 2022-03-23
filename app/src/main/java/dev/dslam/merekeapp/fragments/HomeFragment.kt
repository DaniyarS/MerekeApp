package dev.dslam.merekeapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.dslam.merekeapp.R
import dev.dslam.merekeapp.adapters.CategoryDelegateAdapter
import dev.dslam.merekeapp.adapters.SingerDelegateAdapter
import dev.dslam.merekeapp.adapters.VenueDelegateAdapter
import dev.dslam.merekeapp.databinding.FragmentHomeBinding
import dev.dslam.merekeapp.interfaces.DelegateAdapterItem
import dev.dslam.merekeapp.models.Category
import dev.dslam.merekeapp.models.LoadingState
import dev.dslam.merekeapp.models.Status
import dev.dslam.merekeapp.models.adaptermodels.CategoryItem
import dev.dslam.merekeapp.models.adaptermodels.VenueItem
import dev.dslam.merekeapp.utils.composeAdapter.CompositeAdapter
import dev.dslam.merekeapp.viewModels.HomeFragmentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(R.layout.fragment_home) {

//    private var _binding: FragmentHomeBinding? = null
//    private val binding = _binding!!

    private val homeFragmentViewModel by viewModel<HomeFragmentViewModel>()

    private val categoryDelegateAdapter by lazy {
        CategoryDelegateAdapter(
            viewAllClickListener = {

            }
        )
    }

    private val singerDelegateAdapter by lazy {
        SingerDelegateAdapter(
            viewClickListener = {

            }
        )
    }

    private val venueDelegateAdapter by lazy {
        VenueDelegateAdapter(
            viewClickListener = {

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val llm = LinearLayoutManager(requireContext())
        llm.orientation = LinearLayoutManager.VERTICAL
        val rv =  view.findViewById<RecyclerView>(R.id.homeFragmentList)
        rv.adapter = compositeAdapter
        rv.layoutManager = llm

        val list: MutableList<DelegateAdapterItem> = mutableListOf()

        homeFragmentViewModel.venueList.observe(this, { venueList ->
            if (venueList != null) {
                val categoryItem = CategoryItem(Category(0, "Новые заведения"))
                list.add(categoryItem)
                venueList.forEach {
                    list.add( VenueItem(it) )
                }

                compositeAdapter.submitList(list)
            }
        })

        homeFragmentViewModel.loadingState.observe(this, {
            when(it.status) {
                Status.FAILED -> Toast.makeText(requireContext(), it.msg, Toast.LENGTH_SHORT).show()
                Status.RUNNING -> Toast.makeText(requireContext(), "Loading", Toast.LENGTH_SHORT).show()
                Status.SUCCESS -> Toast.makeText(requireContext(), "Success", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
