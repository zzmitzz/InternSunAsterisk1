package com.example.firstappandmaybethelast.presenter

import com.example.firstappandmaybethelast.musicdata.Music

interface MainView {
    fun showMusicList(musicList: List<Music>)
    fun showError(message: String)
} 