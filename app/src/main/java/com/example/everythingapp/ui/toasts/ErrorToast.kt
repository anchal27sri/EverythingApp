package com.example.everythingapp.ui.toasts

import android.content.Context
import android.widget.Toast

fun showToast(context: Context, error: String) {
    Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
}