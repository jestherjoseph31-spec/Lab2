package com.example.stherimage

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        val sther= findViewById<ImageView>(R.id.imageView2)
        val save= findViewById<ImageView>(R.id.imageView3)
        val question= findViewById<EditText>(R.id.editTextText)
        val reponse = findViewById<EditText>(R.id.editTextText2)

        sther.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        save.setOnClickListener {
            val champ1=question.text.toString()
            val champ2=reponse.text.toString()
            val data=Intent().apply{

                putExtra("question_key",champ1)
                putExtra("answer_key",champ2)

            }
            setResult(RESULT_OK,data)
            finish()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->

            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}