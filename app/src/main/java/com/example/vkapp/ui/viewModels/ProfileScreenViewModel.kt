package com.example.vkapp.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vkapp.domain.usecases.GetUserUseCase
import com.example.vkapp.mappers.UserMapperPresentation
import com.example.vkapp.network.models.UserModelPresentation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProfileScreenViewModel(
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    private val _user = MutableLiveData<UserModelPresentation?>()
    val user: LiveData<UserModelPresentation?> = _user

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

    fun getUser() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val domainUser = getUserUseCase.execute()
                val presentationUser =
                    UserMapperPresentation.mapDomainUserToPresentation(domainUser)
                _user.postValue(presentationUser)
            } catch (e: Exception) {
                _errorMessage.postValue(e.message)
            }
        }
    }
}