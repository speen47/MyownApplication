package com.example.myownapplication.domain.actor

import com.example.myownapplication.data.Actor
import com.example.myownapplication.data.repository.actor.ActorsRepository
import com.example.myownapplication.data.repository.actor.ActorsRepositoryImpl

class ActorsInteractorImpl : ActorsInteractor {
    private val repository: ActorsRepository = ActorsRepositoryImpl()
    override suspend fun getActors(id: Long): List<Actor> {
        return repository.getActorsFromNetwork(id).map { it.toDomain() }
    }

}