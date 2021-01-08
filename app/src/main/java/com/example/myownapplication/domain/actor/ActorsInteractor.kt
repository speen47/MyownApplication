package com.example.myownapplication.domain.actor

import com.example.myownapplication.data.Actor

interface ActorsInteractor {
    suspend fun getActors(id: Long): List<Actor>

}