package icesi.edu.co.fragmentsapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


//Viewmodel de Actividad
class FormViewModel : ViewModel(){

    val page = MutableLiveData(0)
    var nextEnabled = MutableLiveData(false)

    private var user = User("",-1, "","")
    val userLD = MutableLiveData(user)

    fun nextPage() {
        page.value = (page.value ?: 0).coerceAtMost(1) + 1
    }

    fun previousPage() {
        page.value = (page.value ?: 0).coerceAtLeast(1) - 1
    }

    fun setName(name:String){
        user.name = name
        userLD.value = user
    }

}

data class User(
    var name:String?,
    var age:Int?,
    var email:String?,
    var phoneNumber:String?
)