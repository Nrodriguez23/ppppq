package com.example.codepathmail

import android.icu.text.SimpleDateFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Date

class MainActivity : AppCompatActivity() {

    lateinit var emails: List<Wishlist>


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         val inputList = mutableListOf<String>()
        // Lookup the RecyclerView in activity layout
        val emailsRv = findViewById<RecyclerView>(R.id.rvMain)
        // Fetch the list of emails
        emails = WishlistFetcher.getEmails()
        // Create adapter passing in the list of emails
        val adapter = WishlistAdapter(emails)
        val editText = findViewById<EditText>(R.id.itemText)
        val editText2 = findViewById<EditText>(R.id.urlText)
        val editText3 = findViewById<EditText>(R.id.priceText)
        val editText4 = this.findViewById<EditText>(R.id.Date)

        val sdf = SimpleDateFormat("EEE, MMMM dd, yyyy")
        val current = sdf.format(Date())


        emailsRv.layoutManager = LinearLayoutManager(this)
        // Attach the adapter to the RecyclerView to populate items
        emailsRv.adapter = adapter
        // Set layout manager to position the items
        findViewById<Button>(R.id.loadMoreBtn).setOnClickListener {
            adapter.notifyDataSetChanged()
            val userInput: String = editText.text.toString()
            val userInput2: String = editText2.text.toString()
            val userInput3: String = editText3.text.toString()
            val newEmails = WishlistFetcher.setEmails( userInput ,userInput2,userInput3)
            // Add new emails to existidang list of emails
            (emails as MutableList<Wishlist>).addAll(newEmails)
            // Notify the adapter there's new emails so the RecyclerView layout is updated
            adapter.notifyDataSetChanged()

        }
            // Fetch next 5 emails

            // Add new emails to existing list of emails


        }




    }


