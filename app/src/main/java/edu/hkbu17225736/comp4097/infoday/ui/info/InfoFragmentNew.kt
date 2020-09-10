package edu.hkbu17225736.comp4097.infoday.ui.info

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import edu.hkbu17225736.comp4097.infoday.R

class InfoFragmentNew : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}