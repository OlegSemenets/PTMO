package com.pkndegwa.mycarmaintenance.utils

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * The [EmptyDataObserver] class is used to change the view on a fragment
 * depending on whether there is data to display or not.
 */
class EmptyDataObserver(private val recyclerView: RecyclerView?, private val emptyView: View?): RecyclerView
.AdapterDataObserver() {

    init {
        checkIfEmpty()
    }

    private fun checkIfEmpty() {
        if (emptyView != null && recyclerView!!.adapter != null) {
            val emptyViewVisible = recyclerView.adapter!!.itemCount == 0

            emptyView.visibility = if (emptyViewVisible) View.VISIBLE else View.GONE

            recyclerView.visibility = if (emptyViewVisible) View.GONE else View.VISIBLE
        }
    }

    override fun onChanged() {
        super.onChanged()
        checkIfEmpty()
    }

}