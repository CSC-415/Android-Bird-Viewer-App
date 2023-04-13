package com.example.csc415randyharrisapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.csc415randyharrisapp.ui.adapter.BirdAdapter
import com.example.csc415randyharrisapp.R
import com.example.csc415randyharrisapp.databinding.FragmentBirdListBinding
import com.example.csc415randyharrisapp.viewmodel.BirdViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BirdListFragment : Fragment() {

    private var _binding: FragmentBirdListBinding? = null
    private val binding get() = _binding!!

    private val birdViewModel: BirdViewModel by activityViewModels()
    private val birdAdapter =  BirdAdapter { bird, _ ->
        requireActivity().supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(
                R.id.fragment_container_view,
                BirdDetailFragment.newInstance(bird.id),
            )
            addToBackStack(null)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentBirdListBinding.inflate(inflater, container, false)
        setupObservers()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.birdRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = birdAdapter
        }
        birdViewModel.fillData()
    }

    private fun setupObservers() {
        lifecycleScope.launch {
            birdViewModel.birds.collect { event ->
                when (event) {
                    BirdViewModel.BirdEvent.Failure -> {
                        binding.progressBar.isVisible = false
                        binding.birdRecyclerView.isVisible = false
                        binding.errorMessage.isVisible = true
                    }
                    BirdViewModel.BirdEvent.Loading -> {
                        binding.progressBar.isVisible = true
                        binding.birdRecyclerView.isVisible = false
                        binding.errorMessage.isVisible = false
                    }
                    is BirdViewModel.BirdEvent.Success -> {
                        birdAdapter.refreshData(event.birds)
                        binding.progressBar.isVisible = false
                        binding.errorMessage.isVisible = false
                        binding.birdRecyclerView.isVisible = true
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}