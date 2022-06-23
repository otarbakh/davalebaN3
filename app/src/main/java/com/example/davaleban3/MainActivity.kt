package com.example.davaleban3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.TextKeyListener.clear
import android.util.Patterns
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.davaleban3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSave.setOnClickListener {
            checkField()
            clear()
            save()
        }
    }
    private fun clear() {
        binding.btnClear.setOnClickListener {
            dataClear()

        }
    }

    private fun save() {
        binding.btnSave.setOnClickListener {

            emailValidation()
            userNameValidation()
        }
    }

    private fun userNameValidation() {
        if(binding.etUsername.text.toString().length < 10)
            Toast.makeText(this, "Use 10 or more symbols", Toast.LENGTH_SHORT).show()
    }




    private fun emailValidation() {
        Patterns.EMAIL_ADDRESS.matcher(binding.etEmail.text.toString())
    }

    private fun dataClear() {
        if (
            binding.etUsername.text.isNullOrEmpty().not() ||
            binding.etFirstName.text.isNullOrEmpty().not() ||
            binding.etLastname.text.isNullOrEmpty().not() ||
            binding.etEmail.text.isNullOrEmpty().not() ||
            binding.etAge.text.isNullOrEmpty().not()
        ) {
            binding.etUsername.editableText.clear()
            binding.etFirstName.editableText.clear()
            binding.etLastname.editableText.clear()
            binding.etEmail.editableText.clear()
            binding.etAge.editableText.clear()
            Toast.makeText(this, "Hold To Clear", Toast.LENGTH_SHORT).show()
        } else if (
            binding.etUsername.text.isNullOrEmpty().not() ||
            binding.etFirstName.text.isNullOrEmpty().not() ||
            binding.etLastname.text.isNullOrEmpty().not() ||
            binding.etEmail.text.isNullOrEmpty().not() ||
            binding.etAge.text.isNullOrEmpty().not()
        ) {
            binding.etUsername.isVisible = false
            binding.etFirstName.isVisible = false
            binding.etLastname.isVisible = false
            binding.etEmail.isVisible = false
            binding.etAge.isVisible = false
        }
    }

    private fun checkField() {
        if (binding.etUsername.text.isNullOrEmpty()) {
            Toast.makeText(this, "Please Enter Username", Toast.LENGTH_SHORT).show()
        } else {
            binding.etUsername.isVisible = true
        }
        if (binding.etAge.text.isNullOrEmpty()) {
            Toast.makeText(this, "Enter your age", Toast.LENGTH_SHORT).show()

        } else {
            binding.etAge.isVisible = true
        }

        if (binding.etFirstName.text.isNullOrEmpty()) {
            Toast.makeText(this, "Please Enter your firstname", Toast.LENGTH_SHORT).show()
        } else {
            binding.etFirstName.isVisible = true

        }
        if (binding.etLastname.text.isNullOrEmpty()) {
            Toast.makeText(this, "Please Enter Username", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Please Enter your last name ", Toast.LENGTH_SHORT).show()
        }

    }

}


