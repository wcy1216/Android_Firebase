package edu.hkbu17225736.comp4097.infoday.ui.events

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import edu.hkbu17225736.comp4097.infoday.R
import edu.hkbu17225736.comp4097.infoday.data.AppDatabase
import edu.hkbu17225736.comp4097.infoday.data.SampleData
import edu.hkbu17225736.comp4097.infoday.ui.events.dummy.DummyContent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * A fragment representing a list of Items.
 */
class EventsFragment : Fragment() {

    private var columnCount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_events_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }

                val dept_id = arguments?.getString("dept_id")

                if (dept_id == null) {
                    //adapter = EventRecyclerViewAdapter(DummyContent.ITEMS)
                    //replace this with list of Dept
                    //if dept_id is not set, call at the beginning
                    adapter = DeptRecyclerViewAdapter(SampleData.DEPT)
                    // adapter = EventRecyclerViewAdapter(SampleData.EVENT) //to test Event
                }else{
                    //Otherwise
//                    adapter = EventRecyclerViewAdapter(SampleData.EVENT.filter {
//                        //if (it.deptId == dept_id) true else false   //if they are the same, return true
//                        (it.deptId == dept_id)                        //more elegant
//                    })
                    CoroutineScope(Dispatchers.IO).launch {
                        val dao = AppDatabase.getInstance(context).eventDao()
                        val events = dao.findEventsByDeptID(dept_id)
                        //...
                        //some_other_code // concurrently running here
                        CoroutineScope(Dispatchers.Main).launch {
                            adapter = EventRecyclerViewAdapter(events)
                        }

                    }

                    //enable the back arrow on the screen
                    (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

                }


            }
        }
        return view
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            EventsFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}