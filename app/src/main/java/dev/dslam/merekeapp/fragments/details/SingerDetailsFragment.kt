package dev.dslam.merekeapp.fragments.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.dslam.merekeapp.R
import dev.dslam.merekeapp.databinding.FragmentSingerDetailsBinding
import dev.dslam.merekeapp.models.Singer

class SingerDetailsFragment : Fragment(R.layout.fragment_singer_details) {

    private var _binding: FragmentSingerDetailsBinding? = null
    private val binding
        get() = _binding!!

    companion object {

        private const val SINGER_MODEL = "singer"

        fun newInstance(singer: Singer): SingerDetailsFragment {
            val args = Bundle()
            args.putParcelable(SINGER_MODEL, singer)
            val fragment = SingerDetailsFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentSingerDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
