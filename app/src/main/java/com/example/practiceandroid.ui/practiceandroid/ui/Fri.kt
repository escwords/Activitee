package com.example.practiceandroid.ui.practiceandroid.ui


import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practiceandroid.R
import kotlinx.android.synthetic.main.fragment_fri.view.*


class Fri : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_fri, container, false)
        view.fri_recyclerview.layoutManager = LinearLayoutManager(activity)
       // activityListItem = populateList()
       // val adapter = RecyclerViewAdapter(activityListItem)
       // view.fri_recyclerview.adapter = adapter

        return view
    }


}
