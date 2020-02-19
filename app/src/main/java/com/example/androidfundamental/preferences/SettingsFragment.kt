package com.example.androidfundamental.preferences


import android.content.SharedPreferences
import android.content.SharedPreferences.OnSharedPreferenceChangeListener
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.preference.*
import com.example.androidfundamental.R


/**
 * A simple [Fragment] subclass.
 */
/*class SettingsFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {

        setPreferencesFromResource(R.xml.mypreferences, rootKey)

        val settings: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity)
        val url = settings.getString("url", "https://www.vogella.com/article.rss")
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> {
                // Launch settings activity
                if (resources.getBoolean(R.bool.twoPaneMode)) {
                    fragmentManager?.beginTransaction()
                        ?.replace(R.id.detailFragment, SettingsFragment())?.commit()
                } else {
                    fragmentManager?.beginTransaction()?.addToBackStack(null)
                        ?.replace(R.id.fragment_container, SettingsFragment())?.commit()
                }
                return true
            }
        }
        return false
    }
}*/
class SettingsFragment : PreferenceFragmentCompat(),
    OnSharedPreferenceChangeListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addPreferencesFromResource(R.xml.mypreferences)
        // show the current value in the settings screen
        for (i in 0 until preferenceScreen.preferenceCount) {
            initSummary(preferenceScreen.getPreference(i))
        }
    }

    override fun onResume() {
        super.onResume()
        preferenceScreen.sharedPreferences
            .registerOnSharedPreferenceChangeListener(this)
    }

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.mypreferences, rootKey)

        val settings: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity)
        val url = settings.getString("url", "https://www.vogella.com/article.rss")
    }

    override fun onPause() {
        super.onPause()
        preferenceScreen.sharedPreferences
            .unregisterOnSharedPreferenceChangeListener(this)
    }

    override fun onSharedPreferenceChanged(
        sharedPreferences: SharedPreferences?,
        key: String?
    ) {
        updatePreferences(findPreference(key))
    }

    private fun initSummary(p: Preference) {
        if (p is PreferenceCategory) {
            val cat: PreferenceCategory = p
            for (i in 0 until cat.preferenceCount) {
                initSummary(cat.getPreference(i))
            }
        } else {
            updatePreferences(p)
        }
    }

    private fun updatePreferences(p: Preference) {
        if (p is EditTextPreference) {
            val editTextPref: EditTextPreference = p
            p.setSummary(editTextPref.text)
        }
    }
}




