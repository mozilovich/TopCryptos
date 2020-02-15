package com.example.topcryptos.presentation.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.topcryptos.R
import com.example.topcryptos.presentation.extensions.formatWithDecimalsPlaces
import com.example.topcryptos.presentation.model.CurrencyModel
import kotlinx.android.synthetic.main.item_currency.view.*

class CurrenciesAdapter: RecyclerView.Adapter<CurrenciesAdapter.CurrencyViewHolder>() {

    var items: List<CurrencyModel> = arrayListOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    var onItemClick: ((CurrencyModel) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): CurrencyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_currency, parent, false)
        return CurrencyViewHolder(v)
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, p1: Int) {
        holder.bindView()
    }


    override fun getItemCount(): Int {
        return items.size
    }

    inner class CurrencyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bindView() = with(itemView) {
            val item = items[adapterPosition]

            Glide.with(context).load(item.image).into(iv_currency)

            tv_currency_shortcut.text = item.symbol
            tv_currency_name.text = item.name
            tv_currency_market_cap.text = item.marketCap.formatWithDecimalsPlaces(0)
            tv_currency_price.text = item.currentPrice.toString()

            setOnClickListener {
                onItemClick?.invoke(item)
            }
        }
    }
}