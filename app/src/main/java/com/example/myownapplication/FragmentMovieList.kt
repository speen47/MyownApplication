package com.example.myownapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FragmentMovieList : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movies_list, container, false)

        view?.findViewById<ViewGroup>(R.id.fragment_details_mini)?.apply {
            setOnClickListener {
                requireActivity().supportFragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .add(R.id.main_container, FragmentMoviesDetails())
                    .commit()
            }
        }
        return view
    }
}

