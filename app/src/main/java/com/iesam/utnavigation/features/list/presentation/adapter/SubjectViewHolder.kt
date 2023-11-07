package com.iesam.utnavigation.features.list.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.iesam.utnavigation.app.ext.loadUrl
import com.iesam.utnavigation.databinding.ViewSubjectItemBinding
import com.iesam.utnavigation.features.list.domain.Subject


class SubjectViewHolder(val view: View) :
    RecyclerView.ViewHolder(view) {

    private lateinit var binding: ViewSubjectItemBinding

    fun bind(model: Subject, onClick: (String) -> Unit) {
        binding = ViewSubjectItemBinding.bind(view)

        binding.apply {
            image.loadUrl(model.urlImage)
            name.text = model.name
            description.text = model.description
        }
        view.setOnClickListener {
            onClick.invoke(model.id)
        }
    }


}