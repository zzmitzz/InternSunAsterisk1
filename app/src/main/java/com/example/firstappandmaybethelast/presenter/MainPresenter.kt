package com.example.firstappandmaybethelast.presenter

import com.example.firstappandmaybethelast.datag.ShortTimeData
import com.example.firstappandmaybethelast.model.ServiceLocator
import com.example.firstappandmaybethelast.musicdata.Music
import com.example.firstappandmaybethelast.presenter.MainView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainPresenter(private val view: MainView) {
    private val api = ServiceLocator.apiAction
    private val presenterJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + presenterJob)

    fun fetchMusicList() {
        uiScope.launch {
            try {
                val musicList = withContext(Dispatchers.IO) { api.getSong() }
                ShortTimeData.listMusic = musicList
                view.showMusicList(musicList)
            } catch (e: Exception) {
                view.showError(e.message ?: "Unknown error")
            }
        }
    }

    fun playMusic(music: Music) {

    }

    fun onDestroy() {
        presenterJob.cancel()
    }
}