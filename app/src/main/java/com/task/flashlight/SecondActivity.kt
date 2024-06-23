package com.task.flashlight
import android.content.Context
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity

class SecondActivity : ComponentActivity() {
    private var isFlashOn=false
    private lateinit var cameraManager: CameraManager
    private lateinit var cameraId:String



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_layout)
        val buttonToggle: Button = findViewById(R.id.buttonToggle)
        cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        try {
            cameraId = cameraManager.cameraIdList[0]
        } catch (e: CameraAccessException) {
            e.printStackTrace()
            Toast.makeText(this, "Camera access error",Toast.LENGTH_SHORT).show()
            return
        }
        buttonToggle.setOnClickListener {
            toggleFlashlight()
        }
    }
    private fun toggleFlashlight() {
        try {
            if(isFlashOn) {
                cameraManager.setTorchMode(cameraId, false)
                isFlashOn = false
                Toast.makeText(this, "Flashlight is Off", Toast.LENGTH_SHORT).show()
            } else {
                cameraManager.setTorchMode(cameraId, true)
                isFlashOn = true
                Toast.makeText(this, "Flashlight is ON", Toast.LENGTH_SHORT).show()
            }
        } catch (e: CameraAccessException) {
            e.printStackTrace()
            Toast.makeText(this, "Get a camera access error", Toast.LENGTH_SHORT).show()

        }


    }
}

