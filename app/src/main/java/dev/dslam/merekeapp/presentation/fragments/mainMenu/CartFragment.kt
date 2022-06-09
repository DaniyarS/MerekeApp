package dev.dslam.merekeapp.presentation.fragments.mainMenu

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dev.dslam.merekeapp.R
import dev.dslam.merekeapp.databinding.FragmentCartBinding
import dev.dslam.merekeapp.presentation.adapters.OrderListAdapter
import dev.dslam.merekeapp.presentation.viewModels.CartAction
import dev.dslam.merekeapp.presentation.viewModels.CartState
import dev.dslam.merekeapp.presentation.viewModels.CartViewModel
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

        orderListAdapter.productClicked = { order ->
            try {
                val text = "Здравствуйте, меня зовут Данияр. Обращаюсь по объявлению: ${order.name + order.description.substring(0, 10)}..."

                val toNumber = order.phoneNumber

                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("http://api.whatsapp.com/send?phone=$toNumber&text=$text")
                startActivity(intent)

            } catch (e: PackageManager.NameNotFoundException) {
                Toast.makeText(requireContext(), "WhatsApp не установлен", Toast.LENGTH_SHORT)
                    .show()
            }
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
