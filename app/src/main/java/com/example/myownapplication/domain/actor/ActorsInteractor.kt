package com.example.myownapplication.domain.actor

import com.example.myownapplication.domain.models.Actor

interface ActorsInteractor {
    suspend fun getActors(id: Long): List<Actor>

}