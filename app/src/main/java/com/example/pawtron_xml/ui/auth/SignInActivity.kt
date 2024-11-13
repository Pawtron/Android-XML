package com.example.pawtron_xml.ui.auth

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pawtron_xml.MainActivity
import com.example.pawtron_xml.databinding.ActivitySignInBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class SignInActivity : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth
    private lateinit var binding : ActivitySignInBinding
    private lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth  = Firebase.auth
        viewModel = ViewModelProvider(this).get(AuthViewModel::class.java)

        binding.TIEEmail.addTextChangedListener(object : TextWatcher{

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Do nothing.
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val isValid : Boolean = Patterns.EMAIL_ADDRESS.matcher(s.toString()).matches()
                if (s.toString().isEmpty()){
                    binding.TILEmail.error = "Field Can Not Be Empty"
                }
                else if (!isValid){
                    binding.TILEmail.error = "Invalid Email Address"
                }
                else {
                    binding.TILEmail.error = null
                }
            }

            override fun afterTextChanged(s: Editable?) {
                // Do nothing.
            }

        })

        binding.btnSignIn.setOnClickListener{
            val moveIntent = Intent(this, MainActivity::class.java)
            startActivity(moveIntent)
            finish()
        }

        binding.tvSignGoogle.setOnClickListener{
            Toast.makeText(this, "Sign In With Google", Toast.LENGTH_LONG).show()
        }
    }

    override fun onStart() {
        super.onStart()

        val currentUser = auth.currentUser
        if (currentUser != null){
            val moveIntent = Intent(this, MainActivity::class.java)
            startActivity(moveIntent)
        }
    }
}