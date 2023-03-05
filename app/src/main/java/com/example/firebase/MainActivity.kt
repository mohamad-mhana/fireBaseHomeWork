package com.example.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firebase.databinding.ActivityMainBinding
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var reyeclerView: RecyclerView
    private lateinit var userList: ArrayList<User>
    private lateinit var db: FirebaseFirestore


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.addButton.setOnClickListener {
            val i = Intent(this,MainActivity2::class.java)
            startActivity(i)
        }



    }
    private fun ReadFreomFireBase() {
        db = FirebaseFirestore.getInstance()
        reyeclerView = binding.myRecyclerView
        reyeclerView.layoutManager = LinearLayoutManager(this)
        userList = arrayListOf()

        db.collection("user").get()
            .addOnSuccessListener {
                if (!it.isEmpty)
                    for (data in it.documents) {
                        val user: User? = data.toObject<User>(User::class.java)
                        userList.add(user!!)

                    }
                reyeclerView.adapter = Adapter(userList)


            }

            .addOnFailureListener {
                Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
            }
        reyeclerView.adapter = Adapter(userList)

    }

}