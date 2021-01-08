package com.example.myownapplication.data.repository.actor

import com.example.myownapplication.data.network.actor.ActorDto

interface ActorsRepository {
    suspend fun getActorsFromNetwork(id: Long): List<ActorDto>
}