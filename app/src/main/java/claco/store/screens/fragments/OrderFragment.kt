package claco.store.screens.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.claco.store.R
import com.claco.store.databinding.FragmentOfferBinding
import com.claco.store.databinding.FragmentOrderBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER



class OrderFragment : Fragment() {


    private var _binding: FragmentOrderBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentOrderBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }


}