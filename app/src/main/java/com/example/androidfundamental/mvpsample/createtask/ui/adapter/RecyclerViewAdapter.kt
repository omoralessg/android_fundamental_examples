package com.example.androidfundamental.mvpsample.createtask.ui.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidfundamental.R
import com.example.androidfundamental.retrofitexample.github.GithubRepo

class RecyclerViewAdapter(
    private val data: List<GithubRepo?>?,
    private val itemClickListener: OnItemClickListener
) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var text: TextView = v.findViewById(R.id.txv_repository)
        fun bind(data: GithubRepo?, clickListener: OnItemClickListener) {
            text.text = data?.name
            itemView.setOnClickListener {
                data?.let { it1 -> clickListener.onItemClicked(it1) }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_github_repository, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val answer = data?.get(position)
        holder.bind(answer, itemClickListener)
    }

    override fun getItemCount(): Int {
        return data?.size!!
    }

    interface OnItemClickListener {
        fun onItemClicked(githubRepo: GithubRepo)
    }
}