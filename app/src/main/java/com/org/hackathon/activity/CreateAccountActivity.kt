package com.org.hackathon.activity

import RetrofitClient
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.org.hackathon.databinding.ActivityCreateAccountBinding
import com.org.hackathon.model.DefaultResponse
import retrofit2.Call
import retrofit2.Response


class CreateAccountActivity : AppCompatActivity() {
    lateinit var binding:ActivityCreateAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityCreateAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.LogINBtn.setOnClickListener {
            // Start LoginActivity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }


           binding.CreateAccBtn.setOnClickListener {
               val email = binding.Email.text.toString().trim()
               val number = binding.Number.text.toString().trim()
               val name = binding.Name.text.toString().trim()

               if (email.isEmpty()) {
                   binding.Email.error = "Email required"
                   binding.Email.requestFocus()
                   return@setOnClickListener
               }

               if (number.isEmpty()) {
                   binding.Number.error = "Number required"
                   binding.Number.requestFocus()
                   return@setOnClickListener
               }

               if (name.isEmpty()) {
                   binding.Name.error = "Name required"
                   binding.Name.requestFocus()
                   return@setOnClickListener
               }

                RetrofitClient.instance.createUser(email, name)
                    .enqueue(object :retrofit2.Callback<DefaultResponse>{
                        override fun onResponse(call: Call<DefaultResponse>,response: Response<DefaultResponse>) {
                            if (response.isSuccessful) {
                                val defaultResponse = response.body()
                                Toast.makeText(applicationContext, defaultResponse?.message, Toast.LENGTH_SHORT).show()

                                val intent = Intent(this@CreateAccountActivity, MainActivity::class.java)
                                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                                startActivity(intent)
                                finish()
                            } else {
                                Toast.makeText(applicationContext, "Failed to create account", Toast.LENGTH_SHORT).show()
                            }                        }

                        override fun onFailure(call: Call<DefaultResponse>, t: Throwable) {
                            Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show();
                        }

                    })

           }
    }
}