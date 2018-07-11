package com.gatheringhallstudios.mhworlddatabase.common

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gatheringhallstudios.mhworlddatabase.R

import kotlinx.android.synthetic.main.list_generic.*

/**
 * Creates a fragment that contains a recyclerview.
 * This handles most of the setup and handles a potential memory leak case.
 */
open class RecyclerViewFragment : Fragment() {
    /**
     * Returns the recyclerview owned by this fragment to use directly
     */
    val recyclerView get() = recycler_view!!

    /**
     * Overrides onCreateView to return a list_generic.
     * Instead of overriding this, override "onViewCreated".
     */
    final override fun onCreateView(inflater: LayoutInflater, parent: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.list_generic, parent, false)
    }

    /**
     * Sets the adapter of the internal recyclerview.
     * This function has to be called everytime the view is recreated
     * by overriding onViewCreated().
     */
    fun setAdapter(adapter: RecyclerView.Adapter<*>) {
        recycler_view.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()

        // Removes the adapter from the recyclerview on destroy
        // This also causes the adapter to unregister the view,
        // which prevents a potential cyclical reference memory leak.
        recycler_view.adapter = null
    }
}