package dev.dslam.merekeapp.presentation.fragments.catalog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import dev.dslam.merekeapp.databinding.FragmentSingersBinding
import dev.dslam.merekeapp.presentation.adapters.catalogAdapters.PersonCatalogAdapter
import dev.dslam.merekeapp.utils.EqualSpacingItemDecoration

class SingersFragment : Fragment() {

    private var _binding: FragmentSingersBinding? = null
    private val binding
        get() = _binding!!
    private val singersAdapter = PersonCatalogAdapter()

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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupViews() = with(binding) {
        singersList.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        singersList.adapter = singersAdapter
        singersList.addItemDecoration(
            EqualSpacingItemDecoration(
                8,
                EqualSpacingItemDecoration.GRID
            )
        )
    }

    private fun observeSingers() {

    }
}