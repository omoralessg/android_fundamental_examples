package com.example.androidfundamental.contentprovider

import android.app.Activity
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.database.Cursor
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.androidfundamental.R


class ContactsActivity : Activity() {
    val PERMISSIONS_REQUEST_READ_CONTACTS = 1
    private lateinit var contactView : TextView
    /** Called when the activity is first created.  */
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)
        contactView = findViewById<View>(R.id.contactview) as TextView
        askForPermissions()
    }

    private fun askForPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.READ_CONTACTS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(
                        this,
                        android.Manifest.permission.READ_CONTACTS
                    )
                ) {
                    val builder = AlertDialog.Builder(this)
                    builder.setTitle("Read Contacts permission")
                    builder.setPositiveButton(android.R.string.ok, null)
                    builder.setMessage("Please enable access to contacts.")
                    builder.setOnDismissListener(DialogInterface.OnDismissListener {
                        requestPermissions(
                            arrayOf(android.Manifest.permission.READ_CONTACTS),
                            PERMISSIONS_REQUEST_READ_CONTACTS
                        )
                    })
                    builder.show()
                } else {
                    ActivityCompat.requestPermissions(
                        this,
                        arrayOf(android.Manifest.permission.READ_CONTACTS),
                        PERMISSIONS_REQUEST_READ_CONTACTS
                    )
                }
            } else {
                getContacts()
            }
        } else {
            getContacts()
        }
    }

    private fun getContacts() {
        val cursor: Cursor = contacts
        while (cursor.moveToNext()) {
            val displayName: String = cursor.getString(
                cursor
                    .getColumnIndex(ContactsContract.Data.DISPLAY_NAME)
            )
            contactView.append("Name: ")
            contactView.append(displayName)
            contactView.append("\n")
        }
    }

    // Run query
    private val contacts: Cursor
        private get() { // Run query
            val uri: Uri = ContactsContract.Contacts.CONTENT_URI
            val projection = arrayOf(
                ContactsContract.Contacts._ID,
                ContactsContract.Contacts.DISPLAY_NAME
            )
            val selection = (ContactsContract.Contacts.IN_VISIBLE_GROUP + " = '"
                    + "1" + "'")
            val selectionArgs: Array<String>? = null
            val sortOrder = (ContactsContract.Contacts.DISPLAY_NAME
                    + " COLLATE LOCALIZED ASC")
            val cursor = contentResolver.query(uri, projection, selection, selectionArgs,
                sortOrder)
            return cursor!!
        }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>, grantResults: IntArray
    ) {
        when (requestCode) {
            PERMISSIONS_REQUEST_READ_CONTACTS -> {
                if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    getContacts()
                } else {
                    Toast.makeText(
                        this,
                        "You have disabled a contacts permission",
                        Toast.LENGTH_LONG
                    ).show()
                }
                return
            }
        }
    }
}