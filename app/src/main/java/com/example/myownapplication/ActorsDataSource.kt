package com.example.myownapplication

class ActorsDataSource {
    fun getActors(): List<Actor> {
        return listOf(
                Actor(R.drawable.img_robert, "Robert Downey Jr."),
                Actor(R.drawable.img_evans, "Chris Evans"),
                Actor(R.drawable.img_mark, "Mark Ruffalo"),
                Actor(R.drawable.img_chris, "Chris Hemsworth")
        )
    }
}