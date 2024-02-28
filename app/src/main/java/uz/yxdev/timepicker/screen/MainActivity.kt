package uz.yxdev.timepicker.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import uz.yxdev.timepicker.R
import uz.yxdev.timepicker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        _binding=ActivityMainBinding.inflate(layoutInflater)
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add(
                binding.fragment.id,
                RegisterScreen(),
                "Register Screen"
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}