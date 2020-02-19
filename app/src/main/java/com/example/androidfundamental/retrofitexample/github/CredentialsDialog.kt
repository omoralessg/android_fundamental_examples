package com.example.androidfundamental.retrofitexample.github

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.example.androidfundamental.R

class CredentialsDialog : DialogFragment() {
    lateinit var usernameEditText: EditText
    lateinit var passwordEditText: EditText
    lateinit var listener: ICredentialsDialogListener

    interface ICredentialsDialogListener {
        fun onDialogPositiveClick(
            username: String,
            password: String
        )
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (activity is ICredentialsDialogListener) {
            listener = activity as ICredentialsDialogListener
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val view =
            activity?.layoutInflater?.inflate(R.layout.dialog_credentials, null)
        usernameEditText = view?.findViewById<View>(R.id.username_edittext) as EditText
        passwordEditText = view.findViewById<View>(R.id.password_edittext) as EditText
        usernameEditText.setText(arguments?.getString("username"))
        passwordEditText.setText(arguments?.getString("password"))
        val builder =
            AlertDialog.Builder(activity)
                .setView(view)
                .setTitle("Credentials")
                .setNegativeButton("Cancel", null)
                .setPositiveButton(
                    "Continue"
                ) { dialog, which ->
                    if (listener != null) {
                        listener.onDialogPositiveClick(
                            usernameEditText.text.toString(),
                            passwordEditText.text.toString()
                        )
                    }
                }
        return builder.create()
    }
}