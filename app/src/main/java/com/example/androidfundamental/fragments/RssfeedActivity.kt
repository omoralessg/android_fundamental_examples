package com.example.androidfundamental.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.androidfundamental.R

class RssfeedActivity : FragmentActivity(), ListFragment.OnItemSelectedListener {
    var stateFragment: SelectionStateFragment? = null
    private val manager: FragmentManager = supportFragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rssfeed)
        stateFragment = manager
            .findFragmentByTag("headless") as? SelectionStateFragment
        if (stateFragment == null) {
            stateFragment = SelectionStateFragment()
            manager.beginTransaction()
                .add(stateFragment!!, "headless").commit()
        }
        if (resources.getBoolean(R.bool.twoPaneMode)) { // restore state
            if (stateFragment!!.lastSelection.length > 0) {
                onRssItemSelected(stateFragment!!.lastSelection)
            }
            // otherwise all is good, we use the fragments defined in the layout
            return
        }
        // if savedInstanceState is null we do some cleanup
        if (savedInstanceState != null) { // cleanup any existing fragments in case we are in detailed mode
            manager.executePendingTransactions()
            val fragmentById: Fragment? =
                manager.findFragmentById(R.id.fragment_container)
            if (fragmentById != null) {
                manager.beginTransaction()
                    .remove(fragmentById).commit()
            }
        }
        val listFragment = ListFragment()
        manager.beginTransaction()
            .replace(R.id.fragment_container, listFragment).commit()
    }

    override fun onRssItemSelected(text: String?) {
        stateFragment!!.lastSelection = text!!
        if (resources.getBoolean(R.bool.twoPaneMode)) {
            val fragment = manager
                .findFragmentById(R.id.detailFragment) as DetailFragment
            fragment.setText(text)
        } else { // replace the fragment
            // Create fragment and give it an argument for the selected article
            val newFragment = DetailFragment()
            val args = Bundle()
            args.putString(DetailFragment.EXTRA_TEXT, text)
            newFragment.arguments = args
            val transaction: FragmentTransaction =
                manager.beginTransaction()
            //animations
            transaction.setCustomAnimations(R.animator.slide_up,R.animator.slide_down)
            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.fragment_container, newFragment)
            transaction.addToBackStack(null)
            // Commit the transaction
            transaction.commit()
        }
    }
}