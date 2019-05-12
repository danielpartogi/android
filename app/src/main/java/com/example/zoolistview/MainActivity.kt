package com.example.zoolistview

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.animal_ticket.view.*

class MainActivity : AppCompatActivity() {

    var listOfAnimals = ArrayList<Animal>()
    var adapter:AnimalsAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        listOfAnimals.add(
            Animal("Baboon", "Nlablabalbaablbaalal",R.drawable.baboon, false)
        )
        listOfAnimals.add(
            Animal("BullDog", "Nlablabalbaablbaalal",R.drawable.bulldog, false)
        )
        listOfAnimals.add(
            Animal("Panda", "Nlablabalbaablbaalal",R.drawable.panda, false)
        )
        listOfAnimals.add(
            Animal("Tiger", "Nlablabalbaablbaalal",R.drawable.white_tiger, true)
        )

        adapter = AnimalsAdapter(this, listOfAnimals)
        ListItemView.adapter = adapter
    }

    class AnimalsAdapter:BaseAdapter {

        var listOfAnimals= ArrayList<Animal>()
        var context: Context?=null
        constructor(context: Context, listOfAnimals: ArrayList<Animal>):super(){
            this.listOfAnimals = listOfAnimals
            this.context = context
        }

        @SuppressLint("ViewHolder")
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val animal = listOfAnimals[position]
            if(animal.isKiller == true){
                var inflate = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                var view = inflate.inflate(R.layout.animal_killer_ticket, null)
                view.imageList.setImageResource(animal.image!!)
                view.TitleList.text = animal.name!!
                view.subTitleList.text = animal.des!!

                return view
            }
            else {
                var inflate = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                var view = inflate.inflate(R.layout.animal_ticket, null)
                view.imageList.setImageResource(animal.image!!)
                view.TitleList.text = animal.name!!
                view.subTitleList.text = animal.des!!

                return view
            }
        }
        override fun getItem(position: Int): Any {
            return listOfAnimals[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
           return listOfAnimals.size
        }

    }
}
