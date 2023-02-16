package com.example.csc415randyharrisapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.csc415randyharrisapp.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ChampionDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ChampionDetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_champion_detail, container, false)

        if(arguments != null){
            val name = requireArguments().getString("name")
            val id = requireArguments().getString("id")
            val winrate = requireArguments().getString("winrate")
            val role = requireArguments().getString("role")
            val image = requireArguments().getString("image")

            view.findViewById<TextView>(R.id.champion_name).text = name
            view.findViewById<TextView>(R.id.champion_id).text = id
            view.findViewById<TextView>(R.id.champion_winrate).text = winrate
            view.findViewById<TextView>(R.id.champion_role).text = role
            //Glide.with(holder.itemView.context).load(champion.image).into(holder.championImage)
            //view.findViewById<ImageView>(R.id.champion_image) =
        }

        return view
    }
}