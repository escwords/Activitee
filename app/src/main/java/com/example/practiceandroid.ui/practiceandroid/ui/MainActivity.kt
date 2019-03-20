package com.example.practiceandroid.ui.practiceandroid.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.practiceandroid.R
import com.example.practiceandroid.ui.practiceandroid.AcivityViewpagerAdapter
import com.example.practiceandroid.ui.practiceandroid.ui.MonFragment
import com.example.practiceandroid.ui.practiceandroid.ui.Thurs
import com.example.practiceandroid.ui.practiceandroid.ui.TuesFragment
import com.example.practiceandroid.ui.practiceandroid.ui.Wednes
import kotlinx.android.synthetic.main.include_recycler_layout.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(main_actionbar)
         supportActionBar!!.setTitle(null)

        pagerTitleStrip.setNonPrimaryAlpha(0.0F)

/*
         button_continue.setOnClickListener {

            val fragment = MonFragment()

            val transaction = supportFragmentManager.beginTransaction()
            transaction.add(R.id.fragment_container,fragment)
                transaction.addToBackStack(null).commit()*/

        val adapter = AcivityViewpagerAdapter(supportFragmentManager)

           adapter.addFragment(MonFragment(),"Monday")
           adapter.addFragment(TuesFragment(),"Tuesday")
          adapter.addFragment(Wednes(),"Wednesday")
        adapter.addFragment(Thurs(),"Thursday")
        adapter.addFragment(Fri(),"Friday")
           activity_viewpager.adapter = adapter

        springdot.setViewPager(activity_viewpager)
    }




}
