package com.example.androidfundamental.fragments

import android.R
import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment

/**
 * A simple [Fragment] subclass.
 */
class MyAlertDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(getActivity()) // set dialog icon
            .setIcon(R.drawable.stat_notify_error) // set Dialog Title
            .setTitle("Alert dialog fragment example") // Set Dialog Message
            .setMessage("This is a message") // positive button
            .setPositiveButton("OK",
                DialogInterface.OnClickListener { dialog, which ->
                    Toast.makeText(
                        getActivity(),
                        "Pressed OK",
                        Toast.LENGTH_SHORT
                    ).show()
                }) // negative button
            .setNegativeButton("Cancel",
                DialogInterface.OnClickListener { dialog, which ->
                    Toast.makeText(
                        getActivity(),
                        "Cancel",
                        Toast.LENGTH_SHORT
                    ).show()
                }).create()
    }
}
