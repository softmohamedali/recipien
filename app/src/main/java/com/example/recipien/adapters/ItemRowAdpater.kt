package com.example.recipien.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recipien.databinding.RecyRowItemBinding
import com.example.recipien.models.FoodRecipe
import com.example.recipien.models.Result
import com.example.recipien.utils.RecipeDiffUtill

class ItemRowAdpater : RecyclerView.Adapter<ItemRowAdpater.ItemViewHolder>() {

    var recipe = emptyList<Result>()

    class ItemViewHolder(private val binding: RecyRowItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(result: Result)
        {
            binding.result=result
            binding.executePendingBindings()
        }

        companion object{
            fun from(parent:ViewGroup):ItemViewHolder
            {
                val layoutInflater=LayoutInflater.from(parent.context)
                val bind=RecyRowItemBinding.inflate(layoutInflater,parent,false)
                return ItemViewHolder(bind)

            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder.from(parent)
    }

    override fun getItemCount(): Int {
        return recipe.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem=recipe[position]
        holder.bind(currentItem)
    }

    fun setData(data:FoodRecipe)
    {
        var diffUtil=RecipeDiffUtill(recipe,data.results)
        var diffResult=DiffUtil.calculateDiff(diffUtil)
        recipe=data.results
        diffResult.dispatchUpdatesTo(this)
    }
}