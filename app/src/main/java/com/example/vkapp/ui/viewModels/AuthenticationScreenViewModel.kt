package com.example.vkapp.ui.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vkapp.network.HttpClient
import com.example.vkapp.network.models.AuthenticationRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AuthenticationScreenViewModel : ViewModel() {

    var login = MutableLiveData<String>("")
    var password = MutableLiveData<String>("")

    private var _usernameMutable = MutableLiveData<String>("")
    var username: LiveData<String> = _usernameMutable

    private var _emailMutable = MutableLiveData<String>("")
    var email: LiveData<String> = _emailMutable

    private var _iconUrlMutable = MutableLiveData<String?>(null)
    var iconUrl: LiveData<String?> = _iconUrlMutable

    private var _errorMessageMutable = MutableLiveData<String?>()
    var errorMessage: LiveData<String?> = _errorMessageMutable

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
                    _usernameMutable.postValue(user.username)
                    _emailMutable.postValue(user.email)
                    _iconUrlMutable.postValue(user.image)
                }
            } catch (e: Exception) {
                _errorMessageMutable.postValue(e.message)
                Log.e("AuthError", e.toString())
            }
        }
    }
}
