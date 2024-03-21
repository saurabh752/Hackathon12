package com.org.hackathon.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import com.org.hackathon.databinding.ActivityLoginBinding
import com.org.hackathon.model.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.CreateAccBtn.setOnClickListener {
            // Start LoginActivity
            val intent = Intent(this, CreateAccountActivity::class.java)
            startActivity(intent)
        }

        binding.LoginBtn.setOnClickListener {
            val password = binding.Password.text.toString().trim()
            val email = binding.EmailNumber.text.toString().trim()


            if (password.isEmpty()) {
                binding.Password.error = "Email required"
                binding.Password.requestFocus()
                return@setOnClickListener
            }

            if (email.isEmpty()) {
                binding.EmailNumber.error = "Number required"
                binding.EmailNumber.requestFocus()
                return@setOnClickListener
            }


            RetrofitClient.apiService.createLogin(email, password)
                .enqueue(object: Callback<LoginResponse>{
                    override fun onResponse(call: Call<LoginResponse>,response: Response<LoginResponse>)
                    {
                        if (response.isSuccessful) {
                            val loginResponse = response.body()
                            Toast.makeText(applicationContext, loginResponse?.message, Toast.LENGTH_SHORT).show()

                            val intent = Intent(this@LoginActivity, MainActivity::class.java)
                            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(applicationContext, "Login failed", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show();

                    }

                })
        }

    }
}