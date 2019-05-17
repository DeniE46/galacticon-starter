package com.raywenderlich.galacticon

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_photo.view.*
import kotlinx.android.synthetic.main.recyclerview_item_row.view.*

class RecyclerAdapter(private val photos: ArrayList<Photo>) : RecyclerView.Adapter<RecyclerAdapter.PhotoHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoHolder {
        //extension from Extensions.kt
        val inflatedView = parent.inflate(R.layout.recyclerview_item_row, false)
        return PhotoHolder(inflatedView)
    }

    override fun getItemCount() = photos.size

    override fun onBindViewHolder(viewHolder: PhotoHolder, position: Int) {
        val photo = photos[position]
        viewHolder.bind(photo)
    }


    class PhotoHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {

        private var view = v
        private var photo: Photo? = null

        init{
            v.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            Log.d("RecyclerView", "CLICK!")
            val context = itemView.context
            val intent = Intent(context, PhotoActivity::class.java)
            intent.putExtra(PHOTO_KEY, photo)
            context.startActivity(intent)
        }

        companion object {
            private val PHOTO_KEY = "PHOTO"
        }


        fun bind(photo:Photo){
            this.photo = photo
            Picasso.with(view.context).load(photo.url).into(view.itemImage)
            view.itemDate.text = photo.humanDate
            view.itemDescription.text = photo.explanation
        }
    }
}