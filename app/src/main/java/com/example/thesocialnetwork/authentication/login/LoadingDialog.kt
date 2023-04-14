package com.example.thesocialnetwork.authentication.login

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import com.example.thesocialnetwork.R

enum class DialogType {
    LOADING, ERROR
}

class LoadingDialog(private val context: Context, private val dialogType: DialogType) {

    private val builder: AlertDialog.Builder = AlertDialog.Builder(context)
    private lateinit var alertDialog: AlertDialog
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private val view: View = inflater.inflate(R.layout.dialog_loading, null)

    private val progressBar: ProgressBar = view.findViewById(R.id.progressBar)
    private val error: TextView = view.findViewById(R.id.error)

    init {
        builder.setView(view)
        builder.setCancelable(true)
    }

    fun show() {
        when (dialogType) {
            DialogType.LOADING -> {
                progressBar.visibility = View.VISIBLE
                error.text = context.getString(R.string.feat_login_loading)
            }
            DialogType.ERROR -> {
                progressBar.visibility = View.GONE
                error.text = context.getString(R.string.feat_login_error)
            }
        }
        alertDialog = builder.create()
        alertDialog.show()
    }

    fun setErrorMessage(errorMessage: String) {
        if (dialogType == DialogType.ERROR) {
            error.text = context.getString(R.string.feat_login_error, errorMessage)
        }
    }

    fun dismiss() {
        if (this::alertDialog.isInitialized) {
            alertDialog.dismiss()
        }
    }

}