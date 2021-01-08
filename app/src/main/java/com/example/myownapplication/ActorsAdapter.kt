package com.example.myownapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.myownapplication.data.Actor

class ActorsAdapter() : RecyclerView.Adapter<ActorsViewHolder>() {


    private var actors = listOf<Actor>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorsViewHolder {
        return ActorsViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.view_holder_actors, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ActorsViewHolder, position: Int) {
        holder.onBind(actors[position])
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

    fun onBind(actor: Actor) {
        name.text = actor.name
        Glide.with(itemView.context)
            .load(actor.picture)
            .apply(RequestOptions().centerCrop())
            .into(avatar)
    }
}