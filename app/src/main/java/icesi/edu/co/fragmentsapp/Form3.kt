package icesi.edu.co.fragmentsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import icesi.edu.co.fragmentsapp.databinding.FragmentForm3Binding
import icesi.edu.co.fragmentsapp.viewmodel.FormViewModel

class Form3 : Fragment() {

    private val viewModel:FormViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentForm3Binding.inflate(layoutInflater, container, false)

        viewModel.userLD.observe(viewLifecycleOwner){ user ->
            binding.nameTV.text = user.name
        }


        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = Form3()
    }

}