package com.example.androidfundamental.fragments

import android.content.Intent

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.androidfundamental.R
import kotlinx.android.synthetic.main.activity_rssfeed.*

class RssfeedActivity : FragmentActivity(), ListFragment.OnItemSelectedListener {
    var stateFragment: SelectionStateFragment? = null
    private val manager: FragmentManager = supportFragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rssfeed)
        setActionBar(toolbar)
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val tb = findViewById<Toolbar>(R.id.toolbar)
        tb.inflateMenu(R.menu.mainmenu)
        tb.setOnMenuItemClickListener { item -> onOptionsItemSelected(item) }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_refresh -> {
                Toast.makeText(this, "Action Refresh selected", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.action_settings -> {
                Toast.makeText(this, "Action Settings selected", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.action_network -> {
                val wirelessIntent = Intent("android.settings.WIRELESS_SETTINGS")
                startActivity(wirelessIntent)
                Toast.makeText(this, "Action Network selected", Toast.LENGTH_SHORT).show()
                return true
            }
            else -> {
            }
        }
        return super.onOptionsItemSelected(item)
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