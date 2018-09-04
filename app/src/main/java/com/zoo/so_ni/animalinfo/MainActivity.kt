package com.zoo.so_ni.animalinfo

import android.content.Context
import android.content.Intent
import android.graphics.ColorSpace
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.animal_ticket.*
import kotlinx.android.synthetic.main.animal_ticket.view.*

class MainActivity : AppCompatActivity() {


    var listOfAnimal =ArrayList<Animal>()
    var adapter:AnimalAdapter?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //load animal
        listOfAnimal.add(Animal("Baboon","The baboon is wild animal",R.drawable.baboon,true))
        listOfAnimal.add(Animal("Bul dog","Does bull dog looks like bull??",R.drawable.bulldog,false))
        listOfAnimal.add(Animal("Panda","Kung Fu panda is my best movie",R.drawable.panda,false))
        listOfAnimal.add(Animal("Birs","The swallow bird is awesome",R.drawable.swallow_bird,false))
        listOfAnimal.add(Animal("Tiger","White Tiger ,is a Tai Lung??",R.drawable.white_tiger,true))
        listOfAnimal.add(Animal("Zebra","Why Zebra is angry with Alan",R.drawable.zebra,false))

        adapter = AnimalAdapter(this,listOfAnimal)



        animalList.adapter = adapter


    }

    fun delAnimal(index:Int)
    {
        listOfAnimal.remove(listOfAnimal[index])
        adapter!!.notifyDataSetChanged()

    }

    fun addAnimal(index:Int)
    {
        listOfAnimal.add(index,listOfAnimal[index])
        adapter!!.notifyDataSetChanged()
    }

  inner  class AnimalAdapter:BaseAdapter
    {


        var context: Context?= null
        var listOfAnimal = ArrayList<Animal>()

        constructor(context:Context,listOfAnimal:ArrayList<Animal>):super()
        {
            this.context = context
            this.listOfAnimal = listOfAnimal
        }


        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val animal = listOfAnimal[position]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var myView:View
            if(animal.isVegan!!)
            {
                myView = inflator.inflate(R.layout.animal_ticket_killer,null)//root/parente view if needed

                myView.nameAnimal.text = animal.name
                myView.desAnimal.text = animal.des
                myView.imageAnimal.setImageResource(animal.img!!)
                myView.imageAnimal.setOnClickListener {


                    //addAnimal(position)

                    delAnimal(position)
                    /*
                    val intent= Intent(context,Animal_Info::class.java)
                    intent.putExtra("name",animal.name)
                    intent.putExtra("des",animal.des)
                    intent.putExtra("image",animal.img!!)
                    context!!.startActivity(intent)
                    */


                }

            }else
            {
                myView = inflator.inflate(R.layout.animal_ticket,null)//root/parente view if needed

                myView.nameAnimal.text = animal.name
                myView.desAnimal.text = animal.des
                myView.imageAnimal.setImageResource(animal.img!!)

                myView.imageAnimal.setOnClickListener {
                    /*
                    val intent= Intent(context,Animal_Info::class.java)
                    intent.putExtra("name",animal.name!!)
                    intent.putExtra("des",animal.des!!)
                    intent.putExtra("image",animal.img!!)
                    context!!.startActivity(intent)

*/
                 //   addAnimal(position)
                    delAnimal(position)

                }

            }
            return myView
           }

        override fun getItem(position: Int): Any {
            return listOfAnimal[position]
          }

        override fun getItemId(position: Int): Long {
            return position.toLong()
          }

        override fun getCount(): Int {
            return listOfAnimal.size
          }






    }

}
