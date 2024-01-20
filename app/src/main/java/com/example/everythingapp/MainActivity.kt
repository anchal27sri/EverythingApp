/*
  For passphrase, look at git-ignored password text file in the local project.
 */
package com.example.everythingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.everythingapp.converter.util.IUnits
import com.example.everythingapp.converter.util.LengthUnits

class MainActivity : ComponentActivity() {

    private val navigationState: MutableState<ScreenEnums> = mutableStateOf(ScreenEnums.DASHBOARD)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EverythingApp(
                navigationState = navigationState,
            )
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        navigationState.value = ScreenEnums.DASHBOARD
    }
}