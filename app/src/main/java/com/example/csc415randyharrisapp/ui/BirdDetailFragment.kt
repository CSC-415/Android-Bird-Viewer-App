package com.example.csc415randyharrisapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.csc415randyharrisapp.R
import com.example.csc415randyharrisapp.databinding.FragmentBirdDetailBinding
import com.example.csc415randyharrisapp.viewmodel.BirdViewModel
import com.example.csc415randyharrisapp.viewmodel.SingleBirdViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.util.jar.Attributes.Name

@AndroidEntryPoint
class BirdDetailFragment : Fragment() {

    private var _binding: FragmentBirdDetailBinding? = null
    private val binding get() = _binding!!

    private val birdViewModel: SingleBirdViewModel by activityViewModels()

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentBirdDetailBinding.inflate(inflater, container, false)

        if (arguments != null) {
            birdViewModel.getBirdById(requireArguments().getInt(BUNDLE_ID))

            lifecycleScope.launch {
                birdViewModel.bird.collect { event ->
                    when(event){
                        SingleBirdViewModel.BirdEvent.Failure -> { binding.birdId.text = "Error occurred!"}
                        is SingleBirdViewModel.BirdEvent.Success -> {
                            Log.d("After Job Run", event.bird.name)
                            binding.birdId.text = "ID: " + event.bird.id
                            binding.birdName.text = "Name: " + event.bird.name
                            binding.birdFamily.text = "Family: " + event.bird.family
                            binding.birdOrder.text = "Order: " + event.bird.order
                            binding.birdSciName.text = "Scientific Name: " + event.bird.sciName
                            binding.birdStatus.text = "Conservation Status: " + event.bird.status
                            if (event.bird.images?.isEmpty() == true){
                                Glide.with(requireContext())
                                    .load(R.drawable.confused_seagull)
                                    .into(binding.birdImage)
                            }
                            else{
                                Glide.with(requireContext())
                                    .load(event.bird.images?.get(0))
                                    .into(binding.birdImage)
                            }
                        }
                        else -> {
                            binding.birdId.text = "LOADING..."
                        }
                    }
                }
            }



//            val character = characterViewModel.fetchById(requireArguments().getInt(BUNDLE_ID))
//
//            Glide.with(requireContext()).load(character.image).into(binding.characterImage)
//            binding.characterName.text = getString(R.string.name, character.name)
//            binding.characterUniverse.text = character.universe
        }

        return binding.root
    }

    companion object {
        private const val BUNDLE_ID = "bird_id"

        fun newInstance(id: Int) = BirdDetailFragment().apply {
            arguments = bundleOf(BUNDLE_ID to id)
        }
    }
}