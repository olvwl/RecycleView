package com.example.twice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso


class DetailActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private lateinit var textView: TextView
    private lateinit var textView2: TextView
    private lateinit var textt : TextView

    companion object {
        const val EXTRA_IMAGES = "extra_images"
        const val EXTRA_NAMA = "extra_nama"
        const val EXTRA_DESC = "extra_desc"
        const val EXTRA_BIO = "extra_bio"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        imageView = findViewById(R.id.imageView)
        textView = findViewById(R.id.textView)
        textView2 = findViewById(R.id.textView2)
        textt = findViewById(R.id.tv_bio)

        Picasso.get().load(intent.getStringExtra(EXTRA_IMAGES)).into(imageView)
        textView.setText(intent.getStringExtra(EXTRA_NAMA))
        textView2.setText(intent.getStringExtra(EXTRA_DESC))
        textt.setText(intent.getStringExtra(EXTRA_BIO))


        val actionBar = supportActionBar
        actionBar!!.setTitle("Detail")
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}