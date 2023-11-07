package com.iesam.utnavigation.features.list.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.iesam.utnavigation.R
import com.iesam.utnavigation.features.list.domain.Subject

class SubjectAdapter : ListAdapter<Subject, SubjectViewHolder>(SubjectDiffUtil()) {

    lateinit var onClick: (subjectId: String) -> Unit

    fun setEvent(onClick: (String) -> Unit) {
        this.onClick = onClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_subject_item, parent, false)
        return SubjectViewHolder(view)
    }

    override fun getItemCount(): Int = currentList.size

    override fun onBindViewHolder(holder: SubjectViewHolder, position: Int) {
        holder.bind(currentList[position], onClick)
    }
}