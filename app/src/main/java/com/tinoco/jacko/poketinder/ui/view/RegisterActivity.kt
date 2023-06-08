package com.tinoco.jacko.poketinder.ui.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.tinoco.jacko.poketinder.util.SharedPreferenceUtil
import com.tinoco.jacko.poketinder.data.model.User
import com.tinoco.jacko.poketinder.databinding.ActivityRegisterBinding
import com.tinoco.jacko.poketinder.ui.viewmodel.LoginViewModel
import com.tinoco.jacko.poketinder.ui.viewmodel.RegisterViewModel

class RegisterActivity : BaseActivity<ActivityRegisterBinding>(ActivityRegisterBinding::inflate) {

    private lateinit var registerViewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        binding.btnRegister.setOnClickListener{
            startRegistro()
        }

        binding.btnGoLogin.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java ))
        }

        registerViewModel = RegisterViewModel(this)

        registerViewModel.onCreate()

        registerViewModel.emptyFieldsError.observe(this){
            Toast.makeText(this, "Ingrese los datos del usuario", Toast.LENGTH_SHORT).show()
        }

        registerViewModel.notequalspasswordError.observe(this){
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
        }

        registerViewModel.goSuccesActivity.observe(this){
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    fun startRegistro(){
        registerViewModel.validateInputs(
            binding.edtUserName.text.toString(),
            binding.edtEmail.text.toString(),
            binding.edtPassword.text.toString(),
            binding.edtPassword2.text.toString()
        )
    }
}


