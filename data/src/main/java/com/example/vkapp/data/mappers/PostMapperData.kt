package com.example.vkapp.data.mappers

import com.example.vkapp.data.storage.models.DataPostModel
import com.example.vkapp.data.storage.models.DataReactionsRequestModel
import com.example.vkapp.data.storage.models.DataPostsResponse
import com.example.vkapp.data.storage.models.DataReactionsModel
import com.example.vkapp.domain.models.DomainPostModel
import com.example.vkapp.domain.models.DomainReactionsRequestModel
import com.example.vkapp.domain.models.DomainPostsResponse
import com.example.vkapp.domain.models.DomainReactionsModel

class PostMapperData {
    companion object{

        fun mapDataPostResponseToDomain(posts: DataPostsResponse): DomainPostsResponse{
            return DomainPostsResponse(posts.posts.map { mapDataPostToDomain(it) })
        }

        fun mapDataPostToDomain(post: DataPostModel): DomainPostModel{
            return DomainPostModel(
                id = post.id,
                title = post.title,
                body = post.body,
                tags = post.tags,
                reactions = mapDataPostReactionsToDomain(reactions = post.reactions),
                views = post.views,
                userId = post.userId
            )
        }

        fun mapDataPostReactionsToDomain(reactions: DataReactionsModel): DomainReactionsModel{
            return DomainReactionsModel(
                likes = reactions.likes,
                dislikes = reactions.dislikes,
            )
        }

        fun mapDomainPostReactionsToData(reactions: DomainReactionsModel): DataReactionsModel{
            return DataReactionsModel(
                likes = reactions.likes,
                dislikes = reactions.dislikes,
            )
        }

        fun mapDomainPostReactionsRequestToData(requestModel: DomainReactionsRequestModel): DataReactionsRequestModel{
            return DataReactionsRequestModel(
                reactions = mapDomainPostReactionsToData(reactions = requestModel.reactions)
            )
        }
    }
}