package com.task.flashlight
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navigateButton: Button =findViewById(R.id.click)
        navigateButton.setOnClickListener{
            val intent=Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}



