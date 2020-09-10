package edu.hkbu17225736.comp4097.infoday

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat

class InfoFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}