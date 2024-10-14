package com.example.vkapp.mappers

import com.example.uikit.models.PostModel
import com.example.uikit.models.ReactionsModel
import com.example.uikit.models.ReactionsRequestModel
import com.example.vkapp.data.storage.models.DataReactionsModel
import com.example.vkapp.data.storage.models.DataReactionsRequestModel
import com.example.vkapp.domain.models.DomainPostModel
import com.example.vkapp.domain.models.DomainPostsResponse
import com.example.vkapp.domain.models.DomainReactionsModel
import com.example.vkapp.domain.models.DomainReactionsRequestModel

class PostMapperPresentation {
    companion object{

        fun mapDomainPostResponseToPresentation(posts: DomainPostsResponse): List<PostModel>{
            return posts.posts.map { mapDomainPostToPresentation(it) }
        }

        fun mapDomainPostToPresentation(post: DomainPostModel): PostModel {
            return PostModel(
                id = post.id,
                title = post.title,
                body = post.body,
                tags = post.tags,
                reactions = mapDomainPostReactionsToPresentation(reactions = post.reactions),
                views = post.views,
                userId = post.userId
            )
        }

        fun mapDomainPostReactionsToPresentation(reactions: DomainReactionsModel): ReactionsModel {
            return ReactionsModel(
                likes = reactions.likes,
                dislikes = reactions.dislikes,
            )
        }

        fun mapPresentationPostReactionsToDomain(reactions: ReactionsModel): DomainReactionsModel {
            return DomainReactionsModel(
                likes = reactions.likes,
                dislikes = reactions.dislikes,
            )
        }

        fun mapPresentationPostReactionsRequestToDomain(requestModel: ReactionsRequestModel): DomainReactionsRequestModel {
            return DomainReactionsRequestModel(
                reactions = mapPresentationPostReactionsToDomain(reactions = requestModel.reactions)
            )
        }
    }
}