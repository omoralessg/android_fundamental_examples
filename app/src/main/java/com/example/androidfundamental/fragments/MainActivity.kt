package com.example.androidfundamental.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.example.androidfundamental.R
import com.example.androidfundamental.fragments.MyDialogFragment.UserNameListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : FragmentActivity(), UserNameListener , View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showAlertDialogFragment.setOnClickListener(this)
        showCustomFragment.setOnClickListener(this)
    }

    override fun onFinishUserDialog(user: String?) {
        Toast.makeText(this, "Hello, $user", Toast.LENGTH_SHORT).show()
    }

    override fun onClick(view: View) { // close existing dialog fragments
        val manager: FragmentManager = supportFragmentManager
        manager.findFragmentByTag("fragment_edit_name")?.let {
                frag -> manager.beginTransaction().remove(frag).commit()
        }
        
        when (view.id) {
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