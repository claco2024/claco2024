package claco.store.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import claco.store.MainActivity
import com.claco.store.R
import com.claco.store.WebViewTempActivity
import com.claco.store.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    lateinit var binding : ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, WebViewTempActivity::class.java)
            startActivity(intent)
            finish()
        }, 300)
    }
}