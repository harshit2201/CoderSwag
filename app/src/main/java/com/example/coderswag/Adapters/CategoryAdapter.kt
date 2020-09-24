package com.example.coderswag.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.coderswag.Model.Category
import com.example.coderswag.R

class CategoryAdapter(context: Context, categories: List<Category>): BaseAdapter() {

    val context: Context = context
    val categories = categories

    override fun getCount(): Int {
        return categories.count()
    }

    override fun getItem(position: Int): Any {
        return categories[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
//        val layoutInflater = LayoutInflater.from(context)
//        val hehe = layoutInflater.inflate(R.layout.category_list_item, null, false)
//        return hehe

        val categoryView = LayoutInflater.from(context).inflate(R.layout.category_list_item, null)
        val categoryImage: ImageView = categoryView.findViewById(R.id.categoryimage)
        val categoryName: TextView = categoryView.findViewById(R.id.categoryname)

        val category = categories[position]

        // We have stored in our category model is a name an what android worked for is resource ID
        // SO now we have to find resource ID based on name
        // That's what we did below
        val resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName)
        categoryImage.setImageResource(resourceId)

        categoryName.text = category.title
        return categoryView
    }

}