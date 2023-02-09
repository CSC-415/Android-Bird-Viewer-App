package com.example.csc415randyharrisapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChampionAdapter(private val champions: List<Champion>): RecyclerView.Adapter<ChampionAdapter.ChampionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChampionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_card_view, parent, false)

        return ChampionViewHolder(view)
    }

    override fun getItemCount() = champions.size

    override fun onBindViewHolder(holder: ChampionViewHolder, position: Int) {
        val champion = champions[position]
        holder.championImage.setImageResource(champion.image)
        holder.championName.text = champion.name
        holder.championID.text = champion.id
        holder.championWinrate.text = champion.winrate
        holder.championRole.text = champion.role
    }

    class ChampionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val championImage: ImageView = itemView.findViewById(R.id.champion_image)
        val championName: TextView = itemView.findViewById(R.id.champion_name)
        val championID: TextView = itemView.findViewById(R.id.champion_id)
        val championWinrate: TextView = itemView.findViewById(R.id.champion_winrate)
        val championRole: TextView = itemView.findViewById(R.id.champion_role)
    }
}