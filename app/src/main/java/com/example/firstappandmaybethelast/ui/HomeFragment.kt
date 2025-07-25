package com.example.firstappandmaybethelast.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstappandmaybethelast.databinding.FragmentHomeBinding
import android.widget.Toast
import com.example.firstappandmaybethelast.adapter.MusicAdapter
import com.example.firstappandmaybethelast.musicdata.Music
import com.example.firstappandmaybethelast.presenter.MainPresenter
import com.example.firstappandmaybethelast.presenter.MainView
import com.example.firstappandmaybethelast.service.MusicPlayerActivity
import com.example.firstappandmaybethelast.service.MusicPlayerActivity.Companion.mediaPosition

class HomeFragment : Fragment(), MainView {

    private val binding: FragmentHomeBinding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
    }
    private lateinit var presenter: MainPresenter
    private lateinit var adapter: MusicAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = MainPresenter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setupRecycleView()
        presenter.fetchMusicList()
        return binding.root
    }

    private fun setupRecycleView() {
        adapter = MusicAdapter(emptyList()){ position ->
            Intent(this@HomeFragment.requireActivity(), MusicPlayerActivity::class.java).also {
                it.putExtra(mediaPosition, position)
                startActivity(it)
            }
        }
        binding.rcv3.run {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            this.adapter = this@HomeFragment.adapter
        }
    }

    override fun showMusicList(musicList: List<Music>) {
        adapter.updateData(musicList)
    }

    override fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }
}