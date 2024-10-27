package com.example.gmailgui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.widget.ImageView
import androidx.core.content.ContextCompat


class EmailAdapter(private val emailList: List<Email>) : RecyclerView.Adapter<EmailAdapter.EmailViewHolder>() {

    class EmailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val avatar: TextView = itemView.findViewById(R.id.text_avatar)
        val sender: TextView = itemView.findViewById(R.id.text_sender)
        val subject: TextView = itemView.findViewById(R.id.text_subject)
        val preview: TextView = itemView.findViewById(R.id.text_preview)
        val starIcon: ImageView = itemView.findViewById(R.id.icon_star)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_email, parent, false)
        return EmailViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmailViewHolder, position: Int) {
        val email = emailList[position]

        // Set Avatar (initial of sender)
        holder.avatar.text = email.sender.first().toString()

        // Set Email details
        holder.sender.text = email.sender
        holder.subject.text = email.subject
        holder.preview.text = email.preview

        // Set Star icon based on isStarred
        holder.starIcon.setImageResource(
            if (email.isStarred) R.drawable.ic_star_filled else R.drawable.ic_star_outline
        )
        holder.starIcon.setColorFilter(
            if (email.isStarred) ContextCompat.getColor(holder.starIcon.context, android.R.color.holo_red_dark)
            else ContextCompat.getColor(holder.starIcon.context, android.R.color.darker_gray)
        )

        holder.starIcon.setOnClickListener {
            email.isStarred = !email.isStarred
            holder.starIcon.setImageResource(if (email.isStarred) R.drawable.ic_star_filled else R.drawable.ic_star_outline)
        }
    }

    override fun getItemCount() = emailList.size
}