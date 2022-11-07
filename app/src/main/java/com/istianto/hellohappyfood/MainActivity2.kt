package com.istianto.hellohappyfood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.istianto.hellohappyfood.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    companion object {
        const val RECIPE_DATA = "recipe"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = "Recipe"
        }

        val recipeData = intent.getParcelableExtra<Recipes>(RECIPE_DATA)

        if (recipeData != null) {
            binding.apply {
                tvTitle.text = recipeData.title
                tvBahanContext.text = recipeData.bahan
                tvMembuatContext.text = recipeData.buat

                Glide.with(this@MainActivity2)
                    .load(recipeData.images)
                    .into(imgFoods)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}