package icesi.edu.co.fragmentsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import icesi.edu.co.fragmentsapp.databinding.ActivityFormBinding
import icesi.edu.co.fragmentsapp.viewmodel.FormViewModel

class FormActivity : AppCompatActivity() {

    //Instancia del viewmodel
    private val viewModel: FormViewModel by viewModels()

    private val binding by lazy {
        ActivityFormBinding.inflate(layoutInflater)
    }

    private var fragments = arrayOf(
        Form1.newInstance(),
        Form2.newInstance(),
        Form3.newInstance()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel.page.observe(this) {
            loadFragment(fragments[it])
            binding.progressBar.progress = (it  + 1) * (100/fragments.size)
        }
        binding.nextButton.setOnClickListener { viewModel.nextPage() }
        binding.previousButton.setOnClickListener { viewModel.previousPage() }


    }

    private fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragment)
        transaction.commit()
    }

}