package com.vv.zeldaapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

abstract class BaseActivity: AppCompatActivity() {

    abstract val TAG:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.v(TAG,"onCreate() was called")
    }

    override fun onPause() {
        super.onPause()
        Log.v(TAG,"onPause() was called")
    }

    override fun onResume() {
        super.onResume()
        Log.v(TAG,"onResume() was called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(TAG,"onDestroy() was called")
    }

    override fun onStart() {
        super.onStart()
        Log.v(TAG,"onStart() was called")
    }

    override fun onStop() {
        super.onStop()
        Log.v(TAG,"onStop() was called")
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        Log.v(TAG,"onDetachedFromWindow() was called")
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        Log.v(TAG,"onAttachedToWindow() was called")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.v(TAG,"onSaveInstanceState() was called")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.v(TAG,"onRestoreInstanceState() was called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.v(TAG,"onRestart() was called")
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        Log.v(TAG,"onResumeFragments() was called")
    }

    override fun onAttachFragment(fragment: Fragment) {
        super.onAttachFragment(fragment)
        Log.v(TAG,"onAttachFragment() was called")
    }

}