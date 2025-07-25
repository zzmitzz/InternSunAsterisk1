package com.example.firstappandmaybethelast.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.firstappandmaybethelast.R
import com.example.firstappandmaybethelast.musicdata.Music

class MusicAdapter(
    private var musicList: List<Music>,
    private val onClickListener: (Int) -> Unit

) : RecyclerView.Adapter<MusicAdapter.MusicViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_music, parent, false)
        return MusicViewHolder(view)
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        holder.bind(musicList[position])
        holder.itemView.setOnClickListener {
            onClickListener(position)
        }
    }

    override fun getItemCount(): Int = musicList.size

    fun updateData(newList: List<Music>) {
        musicList = newList
        notifyDataSetChanged()
    }

    class MusicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title: TextView = itemView.findViewById(R.id.tvTitle)
        private val artist: TextView = itemView.findViewById(R.id.tvArtist)
        private val genre: TextView = itemView.findViewById(R.id.tvGenre)
        private val duration: TextView = itemView.findViewById(R.id.tvDuration)
        private val image: ImageView = itemView.findViewById(R.id.ivCover)

        fun bind(music: Music) {
            title.text = music.title
            artist.text = music.artist
            genre.text = music.genre
            duration.text = music.durationSeconds?.let { "$it sec" } ?: ""
            Glide.with(itemView.context)
                .load(music.imageUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .into(image)
        }
    }
} 