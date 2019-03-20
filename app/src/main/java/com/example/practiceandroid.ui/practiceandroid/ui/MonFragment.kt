package com.example.practiceandroid.ui.practiceandroid.ui


import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practiceandroid.R
import com.example.practiceandroid.ui.practiceandroid.ActiviteesViewModel.MondayViewModel
import com.example.practiceandroid.ui.practiceandroid.CardViewRecyclerViewItemTouchListener
import com.example.practiceandroid.ui.practiceandroid.Database.MondayItem
import com.example.practiceandroid.ui.practiceandroid.RecyclerViewAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.dialog_view.view.*
import kotlinx.android.synthetic.main.include_recycler_layout.view.*
import kotlinx.android.synthetic.main.main_cardview.view.*
import kotlinx.android.synthetic.main.mon_fragment.view.*
import kotlinx.android.synthetic.main.update_dialog.view.*

class MonFragment : Fragment() {


 override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setHasOptionsMenu(true)
     }

    private lateinit var mondayViewModel: MondayViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View  = inflater.inflate( R.layout.mon_fragment, container, false)
        val  recyclerView = view.findViewById<@androidx.annotation.NonNull RecyclerView>(R.id.recycler_view)
        view.recycler_view.layoutManager = LinearLayoutManager(activity)
        //activityListItem = populateList()

        val adapter = RecyclerViewAdapter(context!!.applicationContext)
        view.recycler_view.adapter = adapter

        mondayViewModel = ViewModelProviders.of(this).get(MondayViewModel::class.java)
        mondayViewModel.allMondayItems.observe(this, Observer<List<MondayItem>> { MondayItem ->
            MondayItem?.let { adapter.setItems(it) }
        })

        view.fab_mon.setOnClickListener {
            val dialogView = LayoutInflater.from(activity).inflate(R.layout.dialog_view,null)
            val dBuilder = AlertDialog.Builder(activity)
                .setView(dialogView)
                .setTitle("Add Activity")
            val alertBuilder = dBuilder.show()
            dialogView.submitBtn.setOnClickListener {
                alertBuilder.dismiss()
                val start = dialogView.dStart.text.toString()
                val end = dialogView.dEnd.text.toString()
                val dtitle = dialogView.dTitle.text.toString()
                val course = dialogView.dCourse.text.toString()
                val lecturer = dialogView.dLecturer.text.toString()
                val venue = dialogView.dVenue.text.toString()
                val mondayitem = MondayItem(
                    0,
                    course,
                    dtitle,
                    lecturer,
                    venue,
                    start,
                    end
                )
                mondayViewModel.insert(mondayitem)
            }
            dialogView.closeBtn.setOnClickListener {
                alertBuilder.dismiss()
            }
        }
        recyclerView.addOnItemTouchListener(CardViewRecyclerViewItemTouchListener(recyclerView,

            intArrayOf(R.id.editBtn,R.id.deleteBtn),

            object : CardViewRecyclerViewItemTouchListener.CarViewClickListener {

                override fun onEditBtnClick(view: View, position: Int) {

                    val itemId = adapter.activityList[position].id

                    Toast.makeText(
                        view.context,
                        "CardView Button EDIT click on id = $itemId   action on position = $position",
                        Toast.LENGTH_LONG
                    ).show()

                    val updateDialog = LayoutInflater.from(activity).inflate(R.layout.update_dialog, null)

                    val dialogBtnBuilder = AlertDialog.Builder(activity)
                        .setView(updateDialog)
                        .setTitle("Modify Activiy")
                    val updateAlertBuilder = dialogBtnBuilder.show()

                    updateDialog.updateBtn.setOnClickListener {
                        updateAlertBuilder.dismiss()
                        val sta = updateDialog.uStart.text.toString()
                        val en = updateDialog.uEnd.text.toString()
                        val dtit = updateDialog.uTitle.text.toString()
                        val cose = updateDialog.uCourse.text.toString()
                        val lect = updateDialog.uLecturer.text.toString()
                        val ven = updateDialog.uVenue.text.toString()

                        mondayViewModel.update(itemId, cose, dtit, lect, ven, sta,en)

                       /* Toast.makeText(
                            view.context,
                            "CardView updated successfully  on id= $itemId on position = $position",
                            Toast.LENGTH_LONG
                        ).show()*/
                    }

                    updateDialog.exitBtn.setOnClickListener {
                        updateAlertBuilder.dismiss()
                    }
                }

                override fun onDeleteBtnClick(view: View, position: Int) {
                    val itemId = adapter.activityList[position].id

                    mondayViewModel.delete(itemId)

                }

                override fun onClick(view: View, position: Int) {
                    //Toast.makeText(view.context, "Single click action on position = $position", Toast.LENGTH_LONG).show()
                }

                override fun onLongClick(view: View, position: Int) {
                    //Toast.makeText(view.context, "CardView long click action on position = $position", Toast.LENGTH_LONG).show()
                }
            }))

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater!!.inflate(R.menu.toolbar_items, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }


}


/*val parent = (view.parent as View)
                 val parentId = parent.id
                 if (parentId == R.id.card_view_id) {
                     //update parent object, because this is your CardView
                     val viewId = view.card_id
                     Toast.makeText(view.context, "update SuccessFull on = $position with id = $viewId", Toast.LENGTH_LONG).show()
                     //mondayViewModel.update()
                 } else {
                     //try to find the parent of your parent
                     val myParentParent = (parent.parent as View)
                     val myParentParentId = myParentParent.id
                     if (myParentParentId == R.id.card_view_id) {
                         //update myParentParent object, because this is your CardView
                        }*/
