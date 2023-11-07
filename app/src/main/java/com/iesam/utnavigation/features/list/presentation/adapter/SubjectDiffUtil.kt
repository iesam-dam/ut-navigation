package com.iesam.utnavigation.features.list.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.iesam.utnavigation.features.list.domain.Subject

class SubjectDiffUtil : DiffUtil.ItemCallback<Subject>() {

    override fun areItemsTheSame(oldItem: Subject, newItem: Subject): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Subject, newItem: Subject): Boolean {
        return oldItem == newItem
    }
}