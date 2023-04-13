package com.example.csc415randyharrisapp.ui.adapter

import android.annotation.SuppressLint
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

    private val birds = mutableListOf<Bird>()

    @SuppressLint("NotifyDataSetChanged")
    fun refreshData(birdList: List<Bird>){
        birds.clear()
        birds.addAll(birdList.subList(0, 20))
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
            Glide
                .with(binding.root)
                .load(bird.images?.get(0))
                .error(R.drawable.baseline_10k_24)
                .into(binding.birdImage)

            binding.birdName.text = bird.name
            binding.birdId.text = bird.id.toString()
        }
    }
}