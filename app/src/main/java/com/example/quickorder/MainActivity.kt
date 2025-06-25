package com.example.quickorder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val apiService = ApiService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val textView = TextView(this)
        setContentView(textView)

        // Call the suspend function from a coroutine scope
        lifecycleScope.launch {
            val result = apiService.getPedidos()
            textView.text = result ?: "No data"
        }
    }
}
