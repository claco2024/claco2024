package claco.store.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.claco.store.R
import com.claco.store.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

  private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_register)

        binding.backBtn.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
        }
    }
}