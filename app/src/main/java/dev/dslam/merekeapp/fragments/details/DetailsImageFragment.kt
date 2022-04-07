package dev.dslam.merekeapp.fragments.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import dev.dslam.merekeapp.databinding.FragmentDetailsImageBinding
import dev.dslam.merekeapp.models.Image

class DetailsImageFragment : Fragment() {

    private var _binding: FragmentDetailsImageBinding? = null
    private val binding
     get() = _binding!!

    companion object {

        private const val IMAGE = "image"

        fun newInstance(image: Image): DetailsImageFragment {
            val args = Bundle()
            args.putParcelable(IMAGE, image)
            val fragment = DetailsImageFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsImageBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (arguments != null) {
            val image = requireArguments().getParcelable<Image>(IMAGE)

            if (image != null) {
                Glide
                    .with(requireContext())
                    .load(image.imageUrl)
                    .into(binding.productImage)
            }
        }
    }
}