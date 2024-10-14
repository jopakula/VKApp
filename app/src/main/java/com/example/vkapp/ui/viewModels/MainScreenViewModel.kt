package com.example.vkapp.ui.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uikit.models.PostModel
import com.example.vkapp.domain.usecases.GetUserUseCase
import com.example.vkapp.mappers.UserMapperPresentation
import com.example.uikit.models.UserModel
import com.example.vkapp.domain.usecases.GetPostsUseCase
import com.example.vkapp.mappers.PostMapperPresentation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainScreenViewModel(
    private val getUserUseCase: GetUserUseCase,
    private val getPostsUseCase: GetPostsUseCase
):ViewModel() {

    private val _posts = MutableLiveData<List<PostModel>>()
    val posts: LiveData<List<PostModel>> = _posts

    private val _user = MutableLiveData<UserModel?>()
    val user: LiveData<UserModel?> = _user

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

    init {
        getPosts()
    }

    fun getUser() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val domainUser = getUserUseCase.execute()
                val presentationUser = UserMapperPresentation.mapDomainUserToPresentation(domainUser)
                _user.postValue(presentationUser)
            } catch (e: Exception) {
                _errorMessage.postValue(e.message)
            }
        }
    }

    fun getPosts() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val domainPostsList = getPostsUseCase.execute()
                val presentationPostsList = PostMapperPresentation.mapDomainPostResponseToPresentation(posts = domainPostsList)
                _posts.postValue(presentationPostsList)
                Log.wtf("AAA", "${posts.value}")
            } catch (e: Exception) {
                _errorMessage.postValue(e.message)
                Log.wtf("AAA", "${e.message}")
            }
        }
    }
}