package com.example.twice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleview.TwiceAdapter
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var rvTwice : RecyclerView
    private var list : ArrayList<Twice> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvTwice = findViewById(R.id.rv_twice)
        rvTwice.setHasFixedSize(true)

        list.addAll(TwiceData.listData)
        showRecycleview()

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.apply {
            title = "Twice"
            subtitle = "One in a Million!"

            setDisplayShowCustomEnabled(true)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.toolbar_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.toolbar_profile -> {
                val intent = Intent(this, About::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showRecycleview() {
        rvTwice.layoutManager = LinearLayoutManager(this)
        val adapter = TwiceAdapter(list)
        rvTwice.adapter = adapter

        adapter.setOnItemClickCallback(object : TwiceAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Twice) {

                val move = Intent(this@MainActivity, DetailActivity::class.java)
                move.putExtra(DetailActivity.EXTRA_IMAGES, data.image)
                move.putExtra(DetailActivity.EXTRA_NAMA, data.name)
                move.putExtra(DetailActivity.EXTRA_DESC, data.facts)
                move.putExtra(DetailActivity.EXTRA_BIO, data.bio)
                startActivity(move)

            }
        })
    }




}