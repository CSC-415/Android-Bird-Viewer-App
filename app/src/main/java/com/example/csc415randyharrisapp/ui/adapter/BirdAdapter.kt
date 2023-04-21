package com.example.csc415randyharrisapp.ui.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.csc415randyharrisapp.R
import com.example.csc415randyharrisapp.model.Bird
import com.example.csc415randyharrisapp.databinding.ActivityCardViewBinding

class BirdAdapter(private val onItemClick: (bird: Bird, adapterPosition: Int) -> Unit) :
    RecyclerView.Adapter<BirdAdapter.BirdViewHolder>() {

    init {
        setHasStableIds(true)
    }

    private var birds = mutableListOf<Bird>()

    @SuppressLint("NotifyDataSetChanged")
    fun refreshData(birdList: List<Bird>){
        birds.clear()
        birds.addAll(birdList)
        Log.d("Refreshing data...", birdList.toString())
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BirdViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ActivityCardViewBinding.inflate(layoutInflater, parent, false)

        return BirdViewHolder(binding) { position ->
            onItemClick(birds[position], position)
        }
    }

    override fun getItemCount() = birds.size

    override fun getItemId(position: Int) = position.toLong()

    override fun onBindViewHolder(holder: BirdViewHolder, position: Int) {
        val bird = birds[position]
        holder.bind(bird)
    }

    inner class BirdViewHolder(
        private val binding: ActivityCardViewBinding,
        private val onItemClick: (adapterPosition: Int) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                onItemClick(adapterPosition)
            }
        }

        fun bind(bird: Bird) {
            var birdImage = ""
            if(bird.images?.size!! >= 1){
                birdImage = bird.images[0]
            }
            Glide
                .with(binding.root)
                .load(birdImage)
                .override(80, 80)
                .error(R.drawable.confused_seagull)
                .into(binding.birdImage)

            binding.birdName.text = bird.name
            binding.birdId.text = bird.id.toString()
        }
    }
}