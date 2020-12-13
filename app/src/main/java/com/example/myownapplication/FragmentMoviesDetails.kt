package com.example.myownapplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

class FragmentMoviesDetails : Fragment() {

    val handlerException = CoroutineExceptionHandler { coroutineContext, throwable ->
        Log.d("Mylog", "exception handled: ${throwable.message}")
    }

    val coroutineContext = SupervisorJob() + Dispatchers.Default + handlerException
    val coroutineScope = CoroutineScope(coroutineContext)

    private lateinit var adapter: ActorsAdapter
    private var recycler: RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_movies_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter = ActorsAdapter()
        // var actors = ActorsDataSource().getActors()
        recycler = view.findViewById(R.id.rv_actors)
        recycler?.adapter = adapter
        recycler?.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)

//        coroutineScope.launch {
//            var movies = loadMovies(requireContext())
//            var actors = movies.

    }
    //  adapter.upDateList(actors)


}

