package com.example.myownapplication.data.repository.actor

import com.example.myownapplication.data.network.RetrofitModule
import com.example.myownapplication.data.network.actor.ActorDto

class ActorsRepositoryImpl : ActorsRepository {
    override suspend fun getActorsFromNetwork(id: Long): List<ActorDto> {
        val baseUrl = RetrofitModule.configurationApi.getConfiguration().images.baseUrl
        val result = RetrofitModule.actorsApi.getActors(id = id).cast
        return result.map {
            it.copy(
                profilePath = it.profilePath?.let { baseUrl + "original" + it }
            )
        }
    }
}