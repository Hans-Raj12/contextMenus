package com.example.activity2lab4

import android.annotation.SuppressLint
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var actionMode : ActionMode? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.imageView)
        registerForContextMenu(imageView)

        imageView.setOnLongClickListener{
            view -> when(actionMode){
                null -> {
                    actionMode = this@MainActivity?.startActionMode(actionModeCallback)!!
                    view.isSelected = true
                    true
                }
                else -> false
            }
        }


    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        menuInflater.inflate(R.menu.context_menu,menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.download-> Toast.makeText(this,"downloading...",Toast.LENGTH_SHORT).show()
            R.id.newTab-> Toast.makeText(this,"Opening in new Tab...",Toast.LENGTH_SHORT).show()
            R.id.googleImage-> Toast.makeText(this,"Image being searched on google...",Toast.LENGTH_SHORT).show()
            R.id.shareImage-> Toast.makeText(this,"image is being share...",Toast.LENGTH_SHORT).show()
        }
        return super.onContextItemSelected(item)
    }

    private val actionModeCallback = object:ActionMode.Callback{
        override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
            mode?.menuInflater?.inflate(R.menu.action_bar_menu,menu)
            val num :Int = 1
            mode?.title = num.toString()
            return true
        }

        override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
            return false
        }

        override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
             when(item?.itemId)
            {
                R.id.touch -> Toast.makeText(this@MainActivity,"touch clicked...",Toast.LENGTH_SHORT).show()
                R.id.pin -> Toast.makeText(this@MainActivity,"pin clicked...",Toast.LENGTH_SHORT).show()
                R.id.paint -> Toast.makeText(this@MainActivity,"color lens clicked...",Toast.LENGTH_SHORT).show()
                R.id.share -> Toast.makeText(this@MainActivity,"label clicked...",Toast.LENGTH_SHORT).show()
            }
            return true
        }

        override fun onDestroyActionMode(mode: ActionMode) {
            actionMode = null

        }

    }


}