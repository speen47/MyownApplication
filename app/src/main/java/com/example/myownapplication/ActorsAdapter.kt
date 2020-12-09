package com.example.myownapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ActorsAdapter(private val clickListener: (Actor) -> Unit) : RecyclerView.Adapter<ActorsViewHolder>() {

    private var actors = listOf<Actor>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorsViewHolder {
        return ActorsViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.view_holder_actors, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ActorsViewHolder, position: Int) {
        holder.onBind(actors[position], clickListener)
    }

    override fun getItemCount(): Int {
        return actors.size
    }

    fun upDateList(newActors: List<Actor>) {
        actors = newActors
        notifyDataSetChanged()
    }

}

class ActorsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val avatar: ImageView = itemView.findViewById(R.id.iv_avatar)
    private val name: TextView = itemView.findViewById(R.id.tv_name)

    fun onBind(actor: Actor, clickListener: (Actor) -> Unit) {
        itemView.setOnClickListener { clickListener(actor) }
        avatar.setImageResource(actor.avatar)
        name.text = actor.name
    }
}