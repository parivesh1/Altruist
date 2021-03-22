package com.example.xml

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.concurrent.timerTask

class Adapter(private val exampleList: List<item>) :
        RecyclerView.Adapter<Adapter.ExampleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.event,
                parent, false)
        return ExampleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val currentItem = exampleList[position]
        holder.imageView.setImageResource(currentItem.ImageResource)
        holder.imageButton.setImageResource(currentItem.ImageResource2)
        holder.imageButton2.setImageResource(currentItem.ImageResource3)
        holder.imageButton3.setImageResource(currentItem.ImageResource4)
        holder.imageButton4.setImageResource(currentItem.ImageResource5)
        holder.imageButton5.setImageResource(currentItem.ImageResource6)
        holder.imageButton6.setImageResource(currentItem.ImageResource7)
        holder.imageButton7.setImageResource(currentItem.ImageResource8)
        holder.textView.text = currentItem.text
        holder.textView3.text = currentItem.text3
    }

    override fun getItemCount() = exampleList.size
    class ExampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val imageButton: ImageButton = itemView.findViewById(R.id.imageButton)
        val imageButton2: ImageButton = itemView.findViewById(R.id.imageButton2)
        val imageButton3: ImageButton = itemView.findViewById(R.id.imageButton3)
        val imageButton4: ImageButton = itemView.findViewById(R.id.imageButton4)
        val imageButton5: ImageButton = itemView.findViewById(R.id.imageButton5)
        val imageButton6: ImageButton = itemView.findViewById(R.id.imageButton6)
        val imageButton7: ImageButton = itemView.findViewById(R.id.imageButton7)
        val textView: TextView = itemView.findViewById(R.id.textView1)
        val textView3: TextView = itemView.findViewById(R.id.textView3)

        init {
            imageButton3.setTag(R.drawable.ic_baseline_auto_awesome_24)
            imageButton3.setOnClickListener {
                if (imageButton3.getTag() == R.drawable.liked) {
                    imageButton3.setImageResource(R.drawable.ic_baseline_auto_awesome_24)
                    imageButton3.setTag(R.drawable.ic_baseline_auto_awesome_24)
                } else {
                    imageButton3.setImageResource(R.drawable.liked)
                    imageButton3.setTag(R.drawable.liked)
                }

            }
            imageView.setOnClickListener(object : DoubleClickListener() {
                override fun onDoubleClick(v: View) {
                    val animation = AnimationUtils.loadAnimation(itemView.context, R.anim.blink_anim)
                    imageButton3.startAnimation(animation)
                    imageButton3.setImageResource(R.drawable.liked)
                    Timer().schedule(timerTask {
                        imageButton3.clearAnimation()
                    }, 1000)
                    imageButton3.setTag(R.drawable.liked)
                }
            })
            imageButton4.setOnClickListener {
                Toast.makeText(itemView.context, "Visit the Official page for more Details!", Toast.LENGTH_SHORT).show()
            }
            imageButton6.setOnClickListener {
                Toast.makeText(itemView.context, "Become a member of the Organisation!!", Toast.LENGTH_SHORT).show()
            }
            imageButton7.setOnClickListener {
                Toast.makeText(itemView.context, "Displays location of the Event!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}