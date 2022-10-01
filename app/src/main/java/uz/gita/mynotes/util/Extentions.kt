package uz.gita.mynotes.util

import android.app.Activity
import android.widget.Toast

fun Activity.toast(massage: String) {
    Toast.makeText(this, massage, Toast.LENGTH_SHORT).show()
}