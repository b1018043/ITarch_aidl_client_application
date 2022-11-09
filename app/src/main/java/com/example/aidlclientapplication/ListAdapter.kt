package com.example.aidlclientapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(private val listener: ItemClickListener): RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    private val data = listOf(100,101,102,200,201,202,203,204,206,207,300,301,302,303,304,305,307,308,400,
            401,402,403,404,405,406,407,408,409,410,411,412,413,414,415,416,417,418,420,421,422,423,424,425,
            426,429,431,444,450,451,493,498,499,500,501,502,503,504,506,507,508,509,510,511,521,522,523,525,599
        )
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val textView: TextView = view.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.list_item_view,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = data[position].toString()
        holder.textView.setOnClickListener{
            listener.movePage(data[position])
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun interface ItemClickListener{
        fun movePage(id: Int)
    }
}