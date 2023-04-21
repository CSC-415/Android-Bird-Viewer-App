package com.example.csc415randyharrisapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.commit
import com.example.csc415randyharrisapp.databinding.ActivityMainBinding
import com.example.csc415randyharrisapp.ui.BirdListFragment
import dagger.hilt.android.AndroidEntryPoint

//Add, Commit, Push, Add, Commit, Push, Add, Commit, Push, Add, Commit, Push, Ainsane Clown Posse
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

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    //lateinit won't be instantiated now, but will be at some point.
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("This is oncreate", "hi1")
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //Can also use .commit
//            .beginTransaction()
//            .add(R.id.fragment_container_view, BirdListFragment())
//            .commit()
        //CTRL ALT L for reformatting code
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add(R.id.fragment_container_view, BirdListFragment())
            Log.d("This is oncreate", "hi2")
        }
    }
}