package com.bakarvin.hunternoteskt.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bakarvin.hunternoteskt.R
import com.bakarvin.hunternoteskt.data.model.monster.ModelMonster
import com.bakarvin.hunternoteskt.databinding.ItemMonsterBinding
import com.bumptech.glide.Glide
import androidx.annotation.NonNull





class MonsterAdapter( val listMonster: ArrayList<ModelMonster>
) : RecyclerView.Adapter<MonsterAdapter.DataMonsterViewHolder>() {



    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int ): MonsterAdapter.DataMonsterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemMonsterBinding: ItemMonsterBinding = ItemMonsterBinding.inflate(layoutInflater,parent,false)
        return DataMonsterViewHolder(itemMonsterBinding)
    }

    override fun onBindViewHolder(holder: MonsterAdapter.DataMonsterViewHolder, position: Int) {
//        holder.bind(listMonster[position])
        with(holder){
            with(listMonster[position]){
                itemMonsterBinding.namaList.text = nameMonster
                itemMonsterBinding.tipeList.text = typeMonster
                Glide.with(holder.itemView.context)
                    .load(R.drawable.unknown)
                    .into(itemMonsterBinding.imgList)
            }
        }
    }

    override fun getItemCount(): Int {
        return listMonster.size
    }

    class DataMonsterViewHolder(val itemMonsterBinding: ItemMonsterBinding) :
        RecyclerView.ViewHolder(itemMonsterBinding.root) {
//        fun bind(monster: ModelMonster){ itemView.apply {
//                namaList.text = monster.nameMonster
//                tipeList.text = monster.typeMonster
//                Glide.with(imgList.context)
//                    .load(R.drawable.unknown)
//                    .into(imgList)
//            }
//        }
    }

    fun addMonsters(listMonster: List<ModelMonster>){
        this.listMonster.apply {
            clear()
            addAll(listMonster)
        }
    }
}