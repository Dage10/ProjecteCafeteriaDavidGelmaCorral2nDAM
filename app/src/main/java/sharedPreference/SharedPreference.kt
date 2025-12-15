package sharedPreference

import android.content.Context

class SharedPreference(private val context: Context) {
    private val prefs = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

    fun guardarUsuari(usuari: String, contrasenya: String) {
        prefs.edit()
            .putString("usuari", usuari)
            .putString("contrasenya", contrasenya)
            .apply()
    }

    fun setEstaLogat(estaLogat: Boolean) {
        prefs.edit().putBoolean("estaLogat", estaLogat).apply()
    }

    fun estaLogat(): Boolean {
        return prefs.getBoolean("estaLogat", false)
    }

    fun getUsuari(): String? {
        return prefs.getString("usuari", null)
    }

    fun getContrasenya(): String? {
        return prefs.getString("contrasenya", null)
    }

    fun logout() {
        prefs.edit().clear().apply()
    }
}