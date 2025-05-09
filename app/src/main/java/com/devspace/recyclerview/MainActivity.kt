package com.devspace.recyclerview


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rvlist = findViewById<RecyclerView>(R.id.rv_list)
        val ivgrid = findViewById<ImageView>(R.id.im_grid)
        val ivlist = findViewById<ImageView>(R.id.im_list)
        val adapter = ContactListAdapter()


        rvlist.adapter = adapter
        rvlist.layoutManager = LinearLayoutManager(this)
        adapter.submitList(contacts)

        ivgrid.setOnClickListener {
            rvlist.layoutManager = GridLayoutManager(this,2)
    }
        ivlist.setOnClickListener {
            rvlist.layoutManager = LinearLayoutManager(this)
        }

        adapter.SetOnClickListener { contact ->
            val intent = Intent(this, ContactDetailsActivity::class.java)

            intent.putExtra("contact", contact.name)
            intent.putExtra("phone", contact.phone)
            intent.putExtra("icon", contact.icon)
            //Log.i("TAG", "onCreate: $contact")

            startActivity(intent)
        }
    }
}

val contacts = listOf(
    Contact(
        name = "Souza",
        phone = "(71) 98765-4871",
        icon = R.drawable.sample1
    ),
    Contact(
        name = "Cardoso",
        phone = "(71) 98765-4365",
        icon = R.drawable.sample2
    ),
    Contact(
        name = "Kiran",
        phone = "(71) 98775-4321",
        icon = R.drawable.sample3
    ),
    Contact(
        name = "Igor Ferrani",
        phone = "(71) 98000-4321",
        icon = R.drawable.sample4
    ),
    Contact(
        name = "R R Santos",
        phone = "(71) 98765-0000",
        icon = R.drawable.sample5
    ),
    Contact(
        name = "Igor Fer",
        phone = "(71) 98065-4021",
        icon = R.drawable.sample6
    ),
    Contact(
        name = "Iani",
        phone = "(71) 98050-4321",
        icon = R.drawable.sample7
    ),
    Contact(
        name = "Ferrani",
        phone = "(71) 98765-4300",
        icon = R.drawable.sample8
    ),
    Contact(
        name = "Feri",
        phone = "(71) 98005-4321",
        icon = R.drawable.sample9
    ),
    Contact(
        name = "Iago",
        phone = "(71) 90765-4321",
        icon = R.drawable.sample10
    ),
    Contact(
        name = "Igor",
        phone = "(71) 98765-4021",
        icon = R.drawable.sample11
    ),
    Contact(
        name = "Ferro",
        phone = "(71) 98065-4321",
        icon = R.drawable.sample12
    ),
    Contact(
        name = "Ivis",
        phone = "(71) 98760-4321",
        icon = R.drawable.sample13
    ),
    Contact(
        name = "Santos",
        phone = "(71) 98065-4321",
        icon = R.drawable.sample14
    ),
    Contact(
        name = "Sandy",
        phone = "(71) 98765-4320",
        icon = R.drawable.sample15
    ),
    Contact(
        name = "Ante",
        phone = "(71) 98765-4021",
        icon = R.drawable.sample16
    )

)