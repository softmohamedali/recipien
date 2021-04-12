package com.example.recipien.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.recipien.models.Result

class RecipeDiffUtill(
    private var oldList:List<Result>,
    private var newList:List<Result>
):DiffUtil.Callback() {
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] === newList[newItemPosition]
    }

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}