package dev.dslam.merekeapp.presentation.fragments.mainMenu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dev.dslam.merekeapp.R
import dev.dslam.merekeapp.databinding.FragmentCartBinding
import dev.dslam.merekeapp.models.adaptermodels.SingerItem
import dev.dslam.merekeapp.presentation.adapters.OrderListAdapter
import dev.dslam.merekeapp.presentation.adapters.PersonListAdapter
import dev.dslam.merekeapp.presentation.viewModels.CartAction
import dev.dslam.merekeapp.presentation.viewModels.CartState
import dev.dslam.merekeapp.presentation.viewModels.CartViewModel
import dev.dslam.merekeapp.utils.EqualSpacingItemDecoration
import dev.dslam.merekeapp.utils.dp
import org.koin.androidx.viewmodel.ext.android.viewModel

class CartFragment : Fragment() {

    private var _binding: FragmentCartBinding? = null
    private val binding
        get() = _binding!!

    private val cartViewModel: CartViewModel by viewModel()
    private val orderListAdapter = OrderListAdapter()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentCartBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cartViewModel.dispach(CartAction.GetOrder)

        configureObservers()

        binding.backButton.setOnClickListener {
            this.findNavController().navigate(R.id.catalogFragment, null, null)
        }
    }

    private fun configureObservers() {
        cartViewModel.state.observe(viewLifecycleOwner) {
            when(it) {
                is CartState.ShowOrders -> {
                    if (!it.orders.isNullOrEmpty()) {
                        binding.orderList.isVisible = true

                        with(binding) {
                            orderList.layoutManager = LinearLayoutManager(this.root.context, LinearLayoutManager.VERTICAL, false)
                            orderList.adapter = orderListAdapter
                            orderListAdapter.submitList(it.orders)
                        }
                    } else {
                        binding.defaultContainer.isVisible = true
                        binding.goBackButton.isVisible = true
                        binding.orderList.isVisible = false
                    }
                }
            }
        }
    }
}
