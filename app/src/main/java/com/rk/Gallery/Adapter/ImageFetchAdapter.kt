package com.rk.Gallery.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import androidx.recyclerview.widget.RecyclerView
import com.rk.Gallery.DataModel.Images
import com.rk.Gallery.ImageUpload
import com.rk.Gallery.databinding.SingleImageBinding
import com.squareup.picasso.Picasso

class ImageFetchAdapter(private var Imglist: MutableList<Images>, var context: ImageUpload, private val itemClickListener: OnItemClickListener):RecyclerView.Adapter<ImageFetchAdapter.MyViewHolder>()
{
    interface OnItemClickListener{
        fun OnDeleteClick(Id:String)
        fun OnDownload(Id:String)
    }
    inner class MyViewHolder(val binding: SingleImageBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    fun anim(view: View)
    {
        val animation=AlphaAnimation(0.0f,1.0f)
        animation.duration=1000
        view.startAnimation(animation)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding=SingleImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return Imglist.size
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        anim(holder.itemView)
        val Img=Imglist[position].ImgId
        Picasso.get().load(Img).into(holder.binding.imageView2)
        holder.itemView.setOnClickListener {
            itemClickListener.OnDeleteClick(Img)
        }
    }
}