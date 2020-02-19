package com.example.androidfundamental.fragments

import android.os.Bundle
import android.view.*
import android.widget.EditText
import android.widget.TextView
import android.widget.TextView.OnEditorActionListener
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.example.androidfundamental.R


/**
 * A simple [Fragment] subclass.
 */
class MyDialogFragment  // Empty constructor required for CredentialsDialog
    : DialogFragment(), OnEditorActionListener {
    private lateinit var mEditText: EditText

    interface UserNameListener {
        fun onFinishUserDialog(user: String?)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_username, container)
        mEditText = view.findViewById<View>(R.id.username) as EditText
        // set this instance as callback for editor action
        mEditText.setOnEditorActionListener(this)
        mEditText.requestFocus()
        dialog?.window?.setSoftInputMode(
            WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE
        )
        dialog?.setTitle("Please enter username")
        return view
    }

    override fun onEditorAction(
        v: TextView?,
        actionId: Int,
        event: KeyEvent?
    ): Boolean { // Return input text to activity
        val activity =
            activity as UserNameListener
        activity.onFinishUserDialog(mEditText.text.toString())
        this.dismiss()
        return true
    }
}