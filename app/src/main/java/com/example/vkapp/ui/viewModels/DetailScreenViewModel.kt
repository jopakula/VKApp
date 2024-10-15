package com.example.vkapp.ui.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uikit.models.PostModel
import com.example.uikit.models.ReactionsModel
import com.example.uikit.models.ReactionsRequestModel
import com.example.vkapp.domain.usecases.GetPostByIdUseCase
import com.example.vkapp.domain.usecases.UpdatePostUseCase
import com.example.vkapp.mappers.PostMapperPresentation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailScreenViewModel(
    private val getPostByIdUseCase: GetPostByIdUseCase,
    private val updatePostUseCase: UpdatePostUseCase,
): ViewModel() {

    private val _post = MutableLiveData<PostModel>()
    val post: LiveData<PostModel> = _post

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

    private var _isLiked = MutableLiveData(false)
    var isLiked: LiveData<Boolean> = _isLiked

    fun getPostById(postId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val domainPost = getPostByIdUseCase.execute(postId = postId)
                val presentationPost = PostMapperPresentation.mapDomainPostToPresentation(post = domainPost)
                _post.postValue(presentationPost)
                Log.wtf("AAA", "${post.value?.reactions}")
            } catch (e: Exception) {
                _errorMessage.postValue(e.message)
            }
        }
    }

    fun updatePostLikes(postId: Int, newLikes: Int, newDislikes: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val currentViews = _post.value?.views ?: 0
                val reactionsRequestModel = ReactionsRequestModel(reactions = ReactionsModel(likes = newLikes, dislikes = newDislikes))
                val domainReactionsRequestModel = PostMapperPresentation.mapPresentationPostReactionsRequestToDomain(requestModel = reactionsRequestModel)
                val updatedPost = updatePostUseCase.execute(postId = postId, reactionsRequestModel = domainReactionsRequestModel)
                val updatedPresentationPost = PostMapperPresentation.mapDomainPostToPresentation(updatedPost)
                val postWithRestoredViews = updatedPresentationPost.copy(views = currentViews)
                _post.postValue(postWithRestoredViews)
            } catch (e: Exception) {
                _errorMessage.postValue(e.message)
            }
        }
    }


    fun toggleLike() {
        val currentPost = _post.value
        if (currentPost != null) {
            val currentLikes = currentPost.reactions.likes
            val isCurrentlyLiked = _isLiked.value ?: false
            val newLikes = if (isCurrentlyLiked) currentLikes - 1 else currentLikes + 1
            _isLiked.postValue(!isCurrentlyLiked)
            updatePostLikes(postId = currentPost.id, newLikes = newLikes, newDislikes = currentPost.reactions.dislikes)
        }
    }
}

