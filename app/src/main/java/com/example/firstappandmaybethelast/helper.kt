package com.example.firstappandmaybethelast

import android.widget.ImageView
import com.squareup.picasso.Picasso

internal fun setImage(imageview: ImageView, url: String){
    Picasso.get()
        .load(url)
        .into(imageview)
}
