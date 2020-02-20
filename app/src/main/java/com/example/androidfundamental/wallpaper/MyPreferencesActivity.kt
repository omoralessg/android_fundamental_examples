package com.example.androidfundamental.wallpaper

import android.os.Bundle
import android.widget.Toast
import androidx.preference.Preference
import androidx.preference.PreferenceFragment
import com.example.androidfundamental.R


class MyPreferencesActivity : PreferenceFragment() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.prefs)

        // add a validator to the "numberofCircles" preference so that it only
        // accepts numbers
        val circlePreference = preferenceScreen.findPreference(
            "numberOfCircles"
        )

        // add the validator
        circlePreference.onPreferenceChangeListener = numberCheckListener
    }

    /**
     * Checks that a preference is a valid numerical value
     */
    internal var numberCheckListener: Preference.OnPreferenceChangeListener =
        Preference.OnPreferenceChangeListener { preference, newValue ->
            // check that the string is an integer
            if (newValue != null && newValue.toString().length > 0
                && newValue.toString().matches("\\d*".toRegex())
            ) {
                return@OnPreferenceChangeListener true
            }
            // If now create a message to the user
            Toast.makeText(
                preference.context, "Invalid Input",
                Toast.LENGTH_SHORT
            ).show()
            false
        }
}
