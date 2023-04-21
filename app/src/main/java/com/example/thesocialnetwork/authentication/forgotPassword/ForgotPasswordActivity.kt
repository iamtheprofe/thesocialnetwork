package com.example.thesocialnetwork.authentication.forgotPassword

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.thesocialnetwork.R
import com.example.thesocialnetwork.databinding.ActivityForgotPasswordBinding
import com.example.thesocialnetwork.resetPassword.ResetPasswordActivity
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class ForgotPasswordActivity : AppCompatActivity() {

    private val viewModel: ForgotPasswordViewModel by viewModels()
    private var binding: ActivityForgotPasswordBinding? = null
    private var loadingDialog: Dialog? = null
    private var errorDialog: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        loadingDialog = Dialog(this)
        loadingDialog?.setContentView(R.layout.loading_dialog)
        loadingDialog?.setCancelable(false)
        loadingDialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        errorDialog = AlertDialog.Builder(this)
            .setTitle(R.string.feat_forgot_password_invalid_email_mobile)
            .setPositiveButton(android.R.string.ok, null)
            .create()

        binding?.submitButton?.setOnClickListener {
            handleSubmit()
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collectLatest { state ->
                    invalidate(state)
                }
            }
        }
    }

    private fun showErrorDialog(state: ForgotPasswordState) {
        if (errorDialog != null && !errorDialog!!.isShowing) {
            errorDialog?.setMessage(getString(R.string.feat_login_error, state.error.toString()))
            errorDialog?.show()
        }
    }

    private fun invalidate(state: ForgotPasswordState) {
        if (state.isLoading && loadingDialog != null) {
            loadingDialog?.show()
        } else {
            loadingDialog?.dismiss()
        }
        if (state.error != null) {
            showErrorDialog(state)
        }
        if (state.token != null) {
            startActivity(Intent(this, ResetPasswordActivity::class.java))
            finish()
        }
    }

    private fun handleSubmit() {
        val emailMobile = binding?.emailMobile?.text.toString()
        viewModel.forgotPassword(emailMobile)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
