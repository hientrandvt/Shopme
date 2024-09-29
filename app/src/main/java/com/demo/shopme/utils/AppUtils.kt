package com.demo.shopme.utils

import android.content.Context
import android.os.Vibrator

/**
 * Created by Tran The Hien on 30,September,2024
 */
object AppUtils {
    fun vibrate(context: Context, duration: Long = 500) {
        val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as? Vibrator
        if (vibrator?.hasVibrator() == true) {
            vibrator.vibrate(duration)
        }
    }
}

