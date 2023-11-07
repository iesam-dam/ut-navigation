package com.iesam.utnavigation.features.detail.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.iesam.utnavigation.app.ext.loadUrl
import com.iesam.utnavigation.databinding.FragmentSubjectDetailBinding

class SubjectDetailFragment : Fragment() {

    private var _binding: FragmentSubjectDetailBinding? = null
    private val binding get() = _binding!!
    val viewModel by viewModels<SubjectDetailViewModel>()

    val args: SubjectDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSubjectDetailBinding.inflate(inflater, container, false)
        setupView()
        return binding.root
    }

    private fun setupView() {
        binding.apply {
            detailToolbar.setNavigationOnClickListener {
                findNavController().navigateUp()
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        viewModel.loadSubject(args.subjectId)
    }

    private fun setupObservers() {
        val observer = Observer<SubjectDetailViewModel.UiState> {
            binding.apply {
                detailToolbar.title = it.subject.name
                image.loadUrl(it.subject.urlImage)
                description.text = it.subject.description
            }
        }
        viewModel.uiState.observe(viewLifecycleOwner, observer)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}