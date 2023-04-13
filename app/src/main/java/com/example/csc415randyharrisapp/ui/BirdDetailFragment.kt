package com.example.csc415randyharrisapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import com.example.csc415randyharrisapp.databinding.FragmentBirdDetailBinding
import com.example.csc415randyharrisapp.viewmodel.BirdViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BirdDetailFragment : Fragment() {

    private var _binding: FragmentBirdDetailBinding? = null
    private val binding get() = _binding!!

    private val birdViewModel: BirdViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentBirdDetailBinding.inflate(inflater, container, false)

        if (arguments != null) {
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
//
//    private val championViewModel: BirdViewModel by activityViewModels()
//
//    private var _binding: FragmentChampionDetailBinding? = null
//    private val binding get() = _binding!!
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        //LEGACY:
//        // Inflate the layout for this fragment
//        // val view = inflater.inflate(R.layout.fragment_champion_detail, container, false)
//
//
//
//        _binding = FragmentChampionDetailBinding.inflate(layoutInflater, container, false)
//
//        val champion = championViewModel.fetchByID(requireArguments().getInt(BUNDLE_ID))
//
//        val name_placeholder = "ChampionOld: ${champion.name}"
//        val id_placeholder = "Riot ID: ${champion.id}"
//        val winrate_placeholder = "Winrate: ${champion.winrate}%"
//        val role_placeholder = "Role: ${champion.role}"
//
//        binding.championName.text = name_placeholder
//        binding.championId.text = id_placeholder
//        binding.championWinrate.text = winrate_placeholder
//        binding.championRole.text = role_placeholder
//
//        //LEGACY:
////        if (arguments != null) {
////            val name = requireArguments().getString("name")
////            val id = requireArguments().getString("id")
////            val winrate = requireArguments().getString("winrate")
////            val role = requireArguments().getString("role")
////            val image = requireArguments().getString("image")
////
////            binding.championName.text = name
////            binding.championId.text = id
////            binding.championWinrate.text = winrate
////            binding.championRole.text = role
////            //binding.championImage.
////
////            //Legacy:
////            //Glide.with(holder.itemView.context).load(champion.image).into(holder.championImage)
////            //view.findViewById<ImageView>(R.id.champion_image) =
////        }
//
//        return binding.root
//    }
//
//    companion object {
//        private const val BUNDLE_ID = "id"
//
//        //Can also use .apply{} here, does the same thing but cuts down on number of lines
//        fun newInstance(id: Int): BirdDetailFragment {
//            val detailFragment = BirdDetailFragment()
//            detailFragment.arguments = bundleOf(BUNDLE_ID to id)
//            return detailFragment
//        }
//    }
}