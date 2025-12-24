package sharedPreference

import android.content.Context

class SharedPreference(private val context: Context) {
    private val prefs = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

    private fun userKey(username: String) = "user_$username"

   
    fun registrarUsuari(usuari: String, contrasenya: String): Boolean {
        val key = userKey(usuari)
        if (prefs.contains(key)) {
            return false
        }
        prefs.edit().putString(key, contrasenya).apply()
        return true
    }

    
    fun validarCredencials(usuari: String, contrasenya: String): Boolean {
        val key = userKey(usuari)
        val guardat = prefs.getString(key, null)
        return guardat != null && guardat == contrasenya
    }

    
    fun setSessioUsuari(usuari: String) {
        prefs.edit()
            .putBoolean("estaLogat", true)
            .putString("usuari_actual", usuari)
            .apply()
    }

    fun estaLogat(): Boolean {
        return prefs.getBoolean("estaLogat", false)
    }


    fun getUsuari(): String? {
        return prefs.getString("usuari_actual", null)
    }

    fun getContrasenyaUsuari(usuari: String): String? {
        return prefs.getString(userKey(usuari), null)
    }

   
    fun logout() {
        prefs.edit().putBoolean("estaLogat", false).remove("usuari_actual").apply()
    }

   
    fun eliminarUsuari(usuari: String) {
        prefs.edit().remove(userKey(usuari)).apply()
    }

    
    fun llistarUsuaris(): List<String> {
        return prefs.all.keys.filter { it.startsWith("user_") }.map { it.removePrefix("user_") }
    }
}