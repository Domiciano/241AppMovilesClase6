package icesi.edu.co.fragmentsapp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import icesi.edu.co.fragmentsapp.databinding.FragmentForm1Binding
import icesi.edu.co.fragmentsapp.viewmodel.FormViewModel


class Form1 : Fragment() {

    private val viewModel:FormViewModel by activityViewModels()
    lateinit var binding:FragmentForm1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentForm1Binding.inflate(inflater, container, false)


        binding.nameET.addTextChangedListener(OnAfterTextChanged{ value ->
            viewModel.setName(value)
        })

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = Form1()
    }
}