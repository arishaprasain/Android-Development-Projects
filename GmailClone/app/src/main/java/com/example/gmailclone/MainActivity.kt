package com.example.gmailclone

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gmailclone.ui.theme.GmailCloneTheme

lateinit var emails: List<Email>

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //binding  the email adapter to recycler view
        val emailsRv = findViewById<RecyclerView>(R.id.emailsRv)
        emails = EmailFetcher.getEmails()
        val adapter = EmailAdapter(emails)
        emailsRv.adapter = adapter
        emailsRv.layoutManager = LinearLayoutManager(this)

        //implementing load more button
        findViewById<Button>(R.id.loadMoreBtn).setOnClickListener()
        {
            val emails5 = EmailFetcher.getNext5Emails()
            (emails as MutableList<Email>).addAll(emails5)
            adapter.notifyDataSetChanged()
        }
    }
}

