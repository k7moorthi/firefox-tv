package org.mozilla.tv.firefox.ext

import java.util.Locale


/**
 * Returns true if the following is true for _any_ of the elements in [allowedLocales]:
 * 1) Language == [this] language
 * 2) No country selected || [this] country is selected country
 */
fun Locale.languageAndMaybeCountryMatch(allowedLocales: Array<out Locale>?): Boolean {
    allowedLocales ?: return false
    return allowedLocales.any { allowed ->
        val languageMatches = allowed.language == this.language
        val countryMatches = allowed.country.isEmpty() ||
                allowed.country == this.country
        return@any languageMatches && countryMatches
    }
}
