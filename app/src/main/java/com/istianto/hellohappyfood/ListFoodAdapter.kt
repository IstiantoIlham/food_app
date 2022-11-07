package com.istianto.hellohappyfood

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.istianto.hellohappyfood.databinding.ItemRowBinding

class ListFoodAdapter(private val listFood: ArrayList<Recipes>) :
    RecyclerView.Adapter<ListFoodAdapter.ListViewHolder>() {
    class ListViewHolder(val binding: ItemRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        return ListViewHolder(ItemRowBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listFood[position]

        holder.binding.apply {
            tvTitle.text = data.title

            Glide.with(root.context)
                .load(data.images)
                .into(imgFoods)

            root.setOnClickListener {
                val intent = Intent(root.context, MainActivity2::class.java)
                intent.putExtra(MainActivity2.RECIPE_DATA, data)
                root.context.startActivity(intent)
            }
        }
    }

    override fun getItemCount() = listFood.size
}