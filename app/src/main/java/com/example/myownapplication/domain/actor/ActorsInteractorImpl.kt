package com.example.myownapplication.domain.actor

import com.example.myownapplication.data.repository.actor.ActorsRepository
import com.example.myownapplication.data.repository.actor.ActorsRepositoryImpl
import com.example.myownapplication.domain.models.Actor

class ActorsInteractorImpl : ActorsInteractor {
    private val repository: ActorsRepository = ActorsRepositoryImpl()
    override suspend fun getActors(id: Long): List<Actor> {
        return repository.getActorsFromNetwork(id).map { it.toDomain() }
    }

}