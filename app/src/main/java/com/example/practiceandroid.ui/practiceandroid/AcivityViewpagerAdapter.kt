package com.example.practiceandroid.ui.practiceandroid

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class AcivityViewpagerAdapter(fm:FragmentManager):FragmentStatePagerAdapter(fm){

    private val listFragment:MutableList<Fragment> = ArrayList()
    private val fragmentTitle:MutableList<String> = ArrayList()

    override fun getItem(position: Int): Fragment {
        return listFragment[position]
    }

    override fun getCount(): Int {
        return listFragment.size
    }

     fun addFragment(fragment:Fragment,title:String){
        listFragment.add(fragment)
         fragmentTitle.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentTitle[position]
    }
}