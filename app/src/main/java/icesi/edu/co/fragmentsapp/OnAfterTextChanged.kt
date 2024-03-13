package icesi.edu.co.fragmentsapp

import android.text.Editable
import android.text.TextWatcher

class OnAfterTextChanged(var action: (String)->Unit) : TextWatcher{
    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
    override fun afterTextChanged(text: Editable?) {
        action(text.toString())
    }
}