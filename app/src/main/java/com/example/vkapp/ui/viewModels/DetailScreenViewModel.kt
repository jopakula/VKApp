package com.example.vkapp.ui.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uikit.models.PostModel
import com.example.vkapp.domain.usecases.GetPostByIdUseCase
import com.example.vkapp.mappers.PostMapperPresentation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailScreenViewModel(
    private val getPostByIdUseCase: GetPostByIdUseCase
): ViewModel() {

    private val _post = MutableLiveData<PostModel>()
    val post: LiveData<PostModel> = _post

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

    fun getPostById(postId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            Log.wtf("AAA", "pressed")
            try {
                val domainPost = getPostByIdUseCase.execute(postId = postId)
                val presentationPost = PostMapperPresentation.mapDomainPostToPresentation(post = domainPost)
                _post.postValue(presentationPost)
                Log.wtf("AAA", "$post")
            } catch (e: Exception) {
                _errorMessage.postValue(e.message)
                Log.wtf("AAA", "${e.message}")
            }
        }
    }
}

