package com.example.csc415randyharrisapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.csc415randyharrisapp.ui.ChampionDetailFragment
import com.example.csc415randyharrisapp.ui.ChampionListFragment
import kotlin.random.Random

//Add, Commit, Push, Add, Commit, Push, Add, Commit, Push, Add, Commit, Push Ainsane Clown Posse
//Fragment lifecycle:
//onAttach() - must be attached to an activity to begin
//onCreate() - once created, do
//onCreateView() - once viewed, do
//onActivityCreated() - once activity parent is created, do
//onStart() - once started, do
//onResume() - once resumed, do
//The fragment is now active
//onPause() - once paused, do
//onStop() - once stopped, do
//onDestroyView() - once view is destroyed, do
//onDestroy() - once destroyed, do
//onDetach() - once detached, do

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Can also use .commit
//            .beginTransaction()
//            .add(R.id.fragment_container_view, ChampionListFragment())
//            .commit()
        //CTRL ALT L for reformatting code
        supportFragmentManager.commit {
            add(R.id.fragment_container_view, ChampionListFragment())
        }
    }
}