package com.example.recipien.bindingadapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import coil.load
import com.example.recipien.R

class RecipenRowBindingAdapter {
    companion object
    {
        @BindingAdapter("loadImgView")
        @JvmStatic
        fun loadImgView(imgView:ImageView,url:String){
            imgView.load(url){
                crossfade(600)
            }
        }


        @BindingAdapter("setLikeNums")
        @JvmStatic
        fun setLikeNums(textview:TextView,like:Int){
            textview.text=like.toString()
        }

        @BindingAdapter("setRepearMinut")
        @JvmStatic
        fun setRepearMinut(textview:TextView,minute:Int){
            textview.text=minute.toString()
        }

        @BindingAdapter("applyVeganColor")
        @JvmStatic
        fun applyVeganColor(view:View,vegan:Boolean){
            if (vegan)
            {
                when(view)
                {
                    is TextView -> {
                        view.setTextColor(
                            ContextCompat.getColor(view.context, R.color.green)
                        )
                    }

                    is ImageView -> {
                        view.setColorFilter(
                            ContextCompat.getColor(view.context, R.color.green)
                        )
                    }
                }
            }
        }
    }
}