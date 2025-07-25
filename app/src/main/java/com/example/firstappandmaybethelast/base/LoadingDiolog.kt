package com.example.firstappandmaybethelast.base

import android.app.Dialog
import android.content.Context
import com.example.firstappandmaybethelast.R

class LoadingDialogs(var context: Context) {
    private var dialogs: Dialog = Dialog(context)
    private lateinit var run: Runnable
    private var handler: android.os.Handler = android.os.Handler()
    init {
        dialogs.setCancelable(false)
        dialogs.setContentView(R.layout.loading_layout_custom)
//        dialogs.requestWindowFeature()
        dialogs.window?.setBackgroundDrawableResource(android.R.color.transparent)
        run = Runnable {
            try {
                if (dialogs.isShowing) {
                    dialogs.hide()
                }
            } catch (e: Exception) {
            }
        }
    }
    fun show() {
        dialogs.show()
        run?.let { handler?.postDelayed(it, 90000) }
    }

    fun hide() {
        dialogs.dismiss()
        try {
            run?.let { handler?.removeCallbacks(it) }
        } catch (e: Exception) {
        }
    }
}