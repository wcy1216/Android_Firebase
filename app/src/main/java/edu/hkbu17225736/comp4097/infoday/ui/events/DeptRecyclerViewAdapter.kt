package edu.hkbu17225736.comp4097.infoday.ui.events

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import edu.hkbu17225736.comp4097.infoday.R
import edu.hkbu17225736.comp4097.infoday.data.Dept

/**
 * [RecyclerView.Adapter] that can display a [DummyItem].
 * TODO: Replace the implementation with code for your data type.
 */
class DeptRecyclerViewAdapter(
    private val values: List<Dept>
) : RecyclerView.Adapter<DeptRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_event_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.deptIDView.text = item.id
        holder.deptNameView.text = item.name
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val deptIDView: TextView = view.findViewById(R.id.titleTextView)
        val deptNameView: TextView = view.findViewById(R.id.detailTextView)

        init {
            view.setOnClickListener{
                it.findNavController().navigate(
                    R.id.action_eventsFragment_self,
                    bundleOf(Pair("dept_id",deptIDView.text.toString()))
                )
            }
        }
    }
}