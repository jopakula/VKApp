package com.example.vkapp.ui.viewModels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vkapp.network.HttpClient
import com.example.vkapp.network.models.AuthenticationRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AuthenticationScreenViewModel : ViewModel() {

    var username by mutableStateOf("")
        private set
    var email by mutableStateOf("")
        private set
    var iconUrl by mutableStateOf<String?>(null)
        private set
    var errorMessage by mutableStateOf<String?>(null)
        private set

    fun authenticate(login: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val user = HttpClient.api?.authentication(
                    AuthenticationRequest(
                        username = login,
                        password = password
                    )
                )
                if (user != null) {
                    username = user.username
                    email = user.email
                    iconUrl = user.image
                }
            } catch (e: Exception) {
                errorMessage = e.message
                Log.e("AuthError", e.toString())
            }
        }
    }
}
