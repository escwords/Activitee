package com.example.practiceandroid.ui.practiceandroid

import android.view.View
import androidx.annotation.IdRes
import androidx.annotation.Nullable
import androidx.recyclerview.widget.RecyclerView
import com.example.practiceandroid.R
import org.jetbrains.annotations.NotNull


open class CardViewRecyclerViewItemTouchListener(@NotNull recycleView: RecyclerView,
                                                 @Nullable @IdRes specialIds: IntArray?,
                                                 @NotNull clickListener: CarViewClickListener)
    : BaseRecyclerViewItemTouchListener<CardViewRecyclerViewItemTouchListener.CarViewClickListener>(recycleView, specialIds, clickListener) {

    companion object {
        private const val SPECIAL_VIEW_CLICK_AREA_EXTENSION = 5//this is gonna be converted to 5dp
    }

    private var clickPadding: Int

    init {
        clickPadding = (SPECIAL_VIEW_CLICK_AREA_EXTENSION * recycleView.resources.displayMetrics.density).toInt()
    }

    interface CarViewClickListener : BaseRecyclerViewItemTouchListener.ClickListener {

        fun onEditBtnClick(view: View, position: Int)
        fun onDeleteBtnClick(view:View,position:Int)

    }

    override fun onSpecialViewClick(@NotNull specialChildView: View,
                                    listPosition: Int) {
        when (specialChildView.id) {
            R.id.editBtn -> mClickListener.onEditBtnClick(specialChildView, listPosition)
            R.id.deleteBtn -> mClickListener.onDeleteBtnClick(specialChildView, listPosition)
            else -> mClickListener.onClick(specialChildView, listPosition)
        }
    }

    override fun getSpecialViewClickPadding(): Int = clickPadding
}