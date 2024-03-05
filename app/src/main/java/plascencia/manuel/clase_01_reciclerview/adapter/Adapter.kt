package plascencia.manuel.clase_01_reciclerview.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import plascencia.manuel.clase_01_reciclerview.R
import plascencia.manuel.clase_01_reciclerview.Cetes
import plascencia.manuel.clase_01_reciclerview.Provider.Companion.superHeroList

class Adapter(private val onClickListener: (Cetes) -> Unit): RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val layoutInflater=LayoutInflater.from(parent.context)
    return ViewHolder(layoutInflater.inflate(R.layout.item_superhero,parent,false))
    }

    override fun getItemCount():Int= superHeroList.size

    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val item = superHeroList[position]
        holder.render(item,onClickListener)
    }
}