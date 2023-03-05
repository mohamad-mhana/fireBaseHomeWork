package com.example.firebase

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.firebase.databinding.ActivityMain2Binding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding :ActivityMain2Binding
    var name:String = ""
    var number:String = ""
    var address:String = ""
    val db = Firebase.firestore


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMain2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        name = binding.editTextName.text.toString()
        address = binding.editTextAddress.text.toString()
        number = binding.editTextNumber.text.toString()

        binding.buttonSave.setOnClickListener {

      this.addFireStorte()

            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)

        }

    }

    fun addFireStorte(){

        val User = hashMapOf(
            "name" to this.name,
            "number" to this.number,
            "address" to this.address
        )

        // Add a new document with a generated ID
        db.collection("User")
            .add(User)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
            }
    }

}
