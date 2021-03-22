package com.example.xml

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StyleSpan
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val List = generateDummyList()
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.adapter = Adapter(List)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
    }

    private fun generateDummyList(): List<item> {

        val list = ArrayList<item>()
        val iR1 = R.drawable.download
        val iR2 = R.drawable.photo
        val iR3 = R.drawable.ic_baseline_more_vert_24
        val iR4 = R.drawable.ic_baseline_auto_awesome_24
        val iR5 = R.drawable.ic_baseline_info_24
        val iR6 = R.drawable.volunteer
        val iR7 = R.drawable.ic_baseline_person_add_24
        val iR8 = R.drawable.ic_baseline_location_on_24
        val name = "Goonj"
        val desc = name + " Goonj envisions to grow as an idea across regions, economies and countries using urban discard as a tool to alleviate poverty and enhance the dignity of the poor in the world. Address basic but neglected issues of the poor by involving them in evolving their own solutions with dignity and urban material as reward."
        val ss = SpannableString(desc)
        val boldspan = StyleSpan(Typeface.BOLD)
        ss.setSpan(boldspan,0,5,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        val ite = item(iR1, iR2, iR3, iR4, iR5, iR6, iR7, iR8, name, ss)
        list += ite
        return list
    }

    fun openProfile(view: View) {
        setContentView(R.layout.profile)
    }

    fun showPopup(view: View) {
        val popup = PopupMenu(this, view)
        popup.inflate(R.menu.header_file)

        popup.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item: MenuItem? ->

            when (item!!.itemId) {
                R.id.header1 -> {
                    Toast.makeText(this@MainActivity, "This will allow users to Share the post!", Toast.LENGTH_SHORT).show()
                }
                R.id.header3 -> {
                    Toast.makeText(this@MainActivity, "This will allow users to report the post!", Toast.LENGTH_SHORT).show()
                }
            }

            true
        })

        popup.show()
    }

    fun back(view: View) {
        setContentView(R.layout.activity_main)

        val List = generateDummyList()
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.adapter = Adapter(List)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
    }

    fun volunteer(view: View) {
        setContentView(R.layout.volunteering)
    }
}