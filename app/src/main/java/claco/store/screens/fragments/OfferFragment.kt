package claco.store.screens.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.claco.store.R
import com.claco.store.databinding.FragmentHomeBinding
import  com.claco.store.databinding.FragmentOfferBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [OfferFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OfferFragment : Fragment() {


    private var _binding: FragmentOfferBinding? = null

    private val binding get() = _binding!!




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentOfferBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }


}