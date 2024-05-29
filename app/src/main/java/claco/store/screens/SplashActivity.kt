package claco.store.screens

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import claco.store.MainActivity
import com.claco.store.R
import com.claco.store.WebViewTempActivity
import com.claco.store.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("claco.store", Context.MODE_PRIVATE)

        // Check if it's the first launch
        val isFirstLaunch = sharedPreferences.getBoolean("isFirstLaunch", true)

        // Delayed redirection
        Handler(Looper.getMainLooper()).postDelayed({
            val redirectIntent = if (isFirstLaunch) {
                // If it's the first launch, redirect to SplashScrollActivity
                Intent(this@SplashActivity, SplashScrollActivity::class.java)
            } else {
                // If it's not the first launch, redirect to WebViewTempActivity
                Intent(this@SplashActivity, WebViewTempActivity::class.java)
            }
            startActivity(redirectIntent)
            finish()
        }, 1500)

        // Update SharedPreferences flag to indicate app has been launched before
        if (isFirstLaunch) {
            sharedPreferences.edit().putBoolean("isFirstLaunch", false).apply()
        }
    }
}
