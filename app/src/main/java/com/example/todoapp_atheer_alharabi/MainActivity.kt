package com.example.todoapp_atheer_alharabi

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.adapter.*

class MainActivity : AppCompatActivity() {
    var arrayToDo = ArrayList<item>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Fb.setOnClickListener {
            dialog()
        }
        Rc.adapter = Adapter(this, arrayToDo)
        Rc.layoutManager = LinearLayoutManager(this)

    }

    fun dialog() {
        val dialogBuilder = AlertDialog.Builder(this)
        val input = EditText(this)
        dialogBuilder.setMessage("")

            .setPositiveButton("Add", DialogInterface.OnClickListener { dialog, id ->
                arrayToDo.add(item(input.text.toString(), false))

                Rc.adapter?.notifyDataSetChanged()
            })
            .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, id ->
                dialog.cancel()
            })

        val alert = dialogBuilder.create()

        alert.setTitle("New item:")

        alert.setView(input)

        alert.show()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menuitem, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.delete -> {
                var i = 0
                while (i < arrayToDo.size) {
                    if (arrayToDo[i].checked == true) {
                        CB.isChecked=false
                        arrayToDo.remove(arrayToDo[i])

                        Rc.adapter?.notifyDataSetChanged()
                        Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show()

                    }
                    i = i + 1
                }




                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}
