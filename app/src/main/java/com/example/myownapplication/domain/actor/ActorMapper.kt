package com.example.myownapplication.domain.actor

import com.example.myownapplication.data.Actor
import com.example.myownapplication.data.network.actor.ActorDto

fun ActorDto.toDomain(): Actor {
    return Actor(
            id = this.id,
            name = this.name,
            picture = this.profilePath
    )
}