package com.example.csc415randyharrisapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.csc415randyharrisapp.ui.ChampionDetailFragment

class ChampionAdapter(private val champions: List<Champion>) :
    RecyclerView.Adapter<ChampionAdapter.ChampionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChampionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_card_view, parent, false)

        return ChampionViewHolder(view) { position ->
            val champion = champions[position]

            val bundle = bundleOf(
                "name" to champion.name,
                "id" to champion.id,
                "winrate" to champion.winrate,
                "role" to champion.role,
                "icon" to champion.image,
            )

            val detailFragment = ChampionDetailFragment()
            detailFragment.arguments = bundle

            val activity = view.context as AppCompatActivity

            activity.supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragment_container_view, detailFragment)
                addToBackStack(null)
            }
        }
    }

    override fun getItemCount() = champions.size

    override fun onBindViewHolder(holder: ChampionViewHolder, position: Int) {
        val champion = champions[position]
        //holder.championImage.setImageResource(champion.image)
        Glide.with(holder.itemView.context).load(champion.image).into(holder.championImage)
        holder.championName.text = champion.name
        holder.championID.text = champion.id
        holder.championWinrate.text = champion.winrate
        holder.championRole.text = champion.role
    }

    inner class ChampionViewHolder(
        itemView: View,
        private val onItemClick: (adapterPosition: Int) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {
        val championImage: ImageView = itemView.findViewById(R.id.champion_image)
        val championName: TextView = itemView.findViewById(R.id.champion_name)
        val championID: TextView = itemView.findViewById(R.id.champion_id)
        val championWinrate: TextView = itemView.findViewById(R.id.champion_winrate)
        val championRole: TextView = itemView.findViewById(R.id.champion_role)

        init {
            itemView.setOnClickListener {
                onItemClick(adapterPosition)
            }
        }
    }
}