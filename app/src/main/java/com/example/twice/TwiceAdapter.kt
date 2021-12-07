package com.example.recycleview


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.twice.R
import com.example.twice.Twice
import com.example.twice.TwiceData
import com.squareup.picasso.Picasso


class TwiceAdapter (private val list: ArrayList<Twice>) : RecyclerView.Adapter<TwiceAdapter.TwiceViewHolder>() {
    private lateinit var imgView : ImageView
    private lateinit var mTextView: TextView
    private lateinit var mTextView2: TextView
    private lateinit var mTextView3: TextView

    private var onItemClickCallback : OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    inner class TwiceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(twice: Twice) {
            with(itemView){
                imgView = itemView.findViewById(R.id.iv_image)
                mTextView2 = itemView.findViewById(R.id.tv_nama)
                mTextView3 = itemView.findViewById(R.id.tv_facts)
                mTextView = itemView.findViewById(R.id.tv_bio)
                Picasso.get().load(twice.image).into(imgView)
                mTextView2.text = twice.name
                mTextView3.text = twice.facts
                itemView.setOnClickListener { onItemClickCallback?.onItemClicked(list[holder.] }

            }

            itemView.setOnClickListener {
                onItemClickCallback?.onItemClicked(twice)
            }
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TwiceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        return TwiceViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: TwiceViewHolder, position: Int) {
        holder.bind(list[position])
    }


    interface OnItemClickCallback {
        fun onItemClicked(data : Twice) {

        }

    }

}