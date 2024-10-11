package com.example.vkapp.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vkapp.domain.usecases.AuthenticateUserUseCase
import com.example.vkapp.domain.usecases.GetUserUseCase
import com.example.vkapp.domain.usecases.SaveUserUseCase
import com.example.vkapp.mappers.UserMapperPresentation
import com.example.vkapp.network.models.AuthenticationRequestModelPresentation
import com.example.vkapp.network.models.UserModelPresentation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AuthenticationScreenViewModel(
    private val authenticateUserUseCase: AuthenticateUserUseCase,
    private val saveUserUseCase: SaveUserUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    var login = MutableLiveData("")
    var password = MutableLiveData("")

    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading

    private val _user = MutableLiveData<UserModelPresentation?>()
    val user: LiveData<UserModelPresentation?> = _user

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

    fun authenticate() {
        val request = AuthenticationRequestModelPresentation(
            username = login.value.orEmpty(),
            password = password.value.orEmpty()
        )
        viewModelScope.launch(Dispatchers.IO) {
            _loading.postValue(true)
            try {
                val domainRequest = UserMapperPresentation.mapPresentationAuthenticationRequestToDomain(request)
                val domainUser = authenticateUserUseCase.execute(authenticationRequest = domainRequest)
                saveUserUseCase.execute(domainUser)
//                val presentationUser = UserMapperPresentation.mapDomainUserToPresentation(domainUser)
//                _user.postValue(presentationUser)
            } catch (e: Exception) {
                _errorMessage.postValue(e.message)
            } finally {
                _loading.postValue(false)
            }
        }
    }

    fun getUser() {
        viewModelScope.launch(Dispatchers.IO) {
            _loading.postValue(true)
            try {
                val domainUser = getUserUseCase.execute()
                val presentationUser = UserMapperPresentation.mapDomainUserToPresentation(domainUser)
                _user.postValue(presentationUser)
            } catch (e: Exception) {
                _errorMessage.postValue(e.message)
            } finally {
                _loading.postValue(false)
            }
        }
    }
}
