package com.example.androidfundamental.contentprovider

import android.app.Activity
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.TextView
import com.example.androidfundamental.R


class ContactsActivity : Activity() {
    /** Called when the activity is first created.  */
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)
        val contactView = findViewById<View>(R.id.contactview) as TextView
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
           // Cursor cursor = getContentResolver().query(contentUri, proj, null, null, null);
            val cursor = contentResolver.query(uri, projection, selection, selectionArgs,
                sortOrder)
            return cursor!!

            /*return managedQuery(
                uri, projection, selection, selectionArgs,
                sortOrder
            )*/
        }
}
