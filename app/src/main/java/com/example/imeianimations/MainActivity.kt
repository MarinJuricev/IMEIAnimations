package com.example.imeianimations

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Tell the system to draw our app from edge-to-edge
        WindowCompat.setDecorFitsSystemWindows(window, false)

        val manager: FragmentManager = supportFragmentManager
        val transaction: FragmentTransaction = manager.beginTransaction()
        transaction.add(R.id.main_container, ImeiAnimationFragment(), ImeiAnimationFragment::class.java.name)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}