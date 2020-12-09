package com.example.myownapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentMoviesDetails : Fragment() {

    private lateinit var adapter: ActorsAdapter
    private var recycler: RecyclerView? = null

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_movies_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter = ActorsAdapter {
            Toast.makeText(requireContext(), "There is no data", Toast.LENGTH_SHORT).show()
        }
        var actors = ActorsDataSource().getActors()
        recycler = view.findViewById(R.id.rv_actors)
        recycler?.adapter = adapter
        recycler?.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)

        adapter.upDateList(actors)
    }
}

