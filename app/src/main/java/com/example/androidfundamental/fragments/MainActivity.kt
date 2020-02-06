package com.example.androidfundamental.fragments

import android.app.ActionBar
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.example.androidfundamental.R
import com.example.androidfundamental.fragments.MyDialogFragment.UserNameListener
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : FragmentActivity(), UserNameListener , View.OnClickListener{
    lateinit var  menuItem: MenuItem
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showAlertDialogFragment.setOnClickListener(this)
        showCustomFragment.setOnClickListener(this)

        val actionBar: ActionBar? = actionBar
        actionBar?.setDisplayOptions(
            ActionBar.DISPLAY_SHOW_HOME
                    or ActionBar.DISPLAY_SHOW_TITLE or ActionBar.DISPLAY_SHOW_CUSTOM
        )


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }

    override fun onFinishUserDialog(user: String?) {
        Toast.makeText(this, "Hello, $user", Toast.LENGTH_SHORT).show()
    }

    override fun onClick(view: View) { // close existing dialog fragments
        val manager: FragmentManager = supportFragmentManager
        val frag = manager.findFragmentByTag("fragment_edit_name")
        if (frag != null) {
            manager.beginTransaction().remove(frag).commit()
        }
        when (view.getId()) {
            R.id.showCustomFragment -> {
                val editNameDialog = MyDialogFragment()
                editNameDialog.show(manager, "fragment_edit_name")
            }
            R.id.showAlertDialogFragment -> {
                val alertDialogFragment = MyAlertDialogFragment()
                alertDialogFragment.show(manager, "fragment_edit_name")
            }
        }
    }
}