package com.iesam.utnavigation.features.list.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.iesam.utnavigation.R
import com.iesam.utnavigation.databinding.FragmentSubjectListBinding
import com.iesam.utnavigation.features.list.presentation.adapter.SubjectAdapter

class SubjectListFragment : Fragment() {

    private var _binding: FragmentSubjectListBinding? = null
    private val binding get() = _binding!!

    val viewModel by viewModels<SubjectListViewModel>()

    val subjectAdapter = SubjectAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSubjectListBinding.inflate(inflater, container, false)
        setupView()
        return binding.root
    }

    private fun setupView() {
        binding.apply {
            layoutList.toolbar.apply {
                title = getString(R.string.fragment_list_title)
            }
            listSubject.apply {
                layoutManager = LinearLayoutManager(
                    requireContext(),
                    LinearLayoutManager.VERTICAL,
                    false
                )
                adapter = subjectAdapter
                subjectAdapter.onClick = { subjectId ->
                    findNavController().navigate(
                        SubjectListFragmentDirections.actionFromFragmentListToFragmentDetail(
                            subjectId
                        )
                    )
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        viewModel.loadSubjects()
    }

    private fun setupObservers() {
        val observer = Observer<SubjectListViewModel.UiState> {
            subjectAdapter.submitList(it.subjects)
        }
        viewModel.uiState.observe(viewLifecycleOwner, observer)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}