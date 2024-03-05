package plascencia.manuel.clase_01_reciclerview.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import plascencia.manuel.clase_01_reciclerview.Cetes
import plascencia.manuel.clase_01_reciclerview.databinding.ItemSuperheroBinding

class ViewHolder(view: View): ViewHolder(view) {

   private val binding  =  ItemSuperheroBinding.bind(view)

    fun render(superHeroModel: Cetes, onClickListener: (Cetes)->Unit){
        binding.tvSuperHeroName.text=superHeroModel.superhero
        binding.tvPublisher.text=superHeroModel.publisher
        Glide.with(binding.ivSuperhero.context).load(superHeroModel.photo).into(binding.ivSuperhero)
        itemView.setOnClickListener{onClickListener(superHeroModel)

        }
    }

    private fun onClickListener(superHeroModel: Cetes) {

    }


}