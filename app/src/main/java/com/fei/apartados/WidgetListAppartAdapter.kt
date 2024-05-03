package com.fei.apartados

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat

class WidgetListAppartAdapter(context: Context, widgetsList: List<WidgetListAppart>) :
    ArrayAdapter<WidgetListAppart>(context, R.layout.widget_list_appart, widgetsList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.widget_list_appart, parent, false)
        }

        val widget = getItem(position)

        val textViewID = view!!.findViewById<TextView>(R.id.textViewID)
        val textViewClient = view.findViewById<TextView>(R.id.textViewClient)
        val textViewDate = view.findViewById<TextView>(R.id.textViewDate)
        val textViewAmount = view.findViewById<TextView>(R.id.textViewAmount)
        val textViewArticles = view.findViewById<TextView>(R.id.textViewArticles)
        val relativeLayout = view.findViewById<RelativeLayout>(R.id.profile)

        textViewID.text = widget?.id.toString()
        textViewClient.text = widget?.client
        textViewDate.text = widget?.date
        textViewAmount.text = widget?.amount
        textViewArticles.text = widget?.articles


        when (widget?.status) {
            'n' -> {
                relativeLayout.backgroundTintList = ContextCompat.getColorStateList(context, R.color.statusN)
            }
            's' -> {
                relativeLayout.backgroundTintList = ContextCompat.getColorStateList(context, R.color.statusS)
            }
            'd' -> {
                relativeLayout.backgroundTintList = ContextCompat.getColorStateList(context, R.color.statusD)
            }
            'e' -> {
                relativeLayout.backgroundTintList = ContextCompat.getColorStateList(context, R.color.statusE)
            }
            else -> {

            }
        }


        return view
    }

}
