package com.example.month3_hw4;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.month3_hw4.databinding.ItemPizzaBinding;

import java.util.ArrayList;

public class PizzaAdapter extends RecyclerView.Adapter<PizzaViewHolder> {

    ArrayList<PizzaModel> pizza;
    OnItemClick onItemClick;

    public PizzaAdapter(ArrayList<PizzaModel> pizza, OnItemClick onItemClick) {
        this.pizza = pizza;
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public PizzaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PizzaViewHolder(ItemPizzaBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PizzaViewHolder holder,
                                 @SuppressLint("RecyclerView") int position) {
        holder.onBind(pizza.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClick.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pizza.size();
    }
}

class PizzaViewHolder extends RecyclerView.ViewHolder {

    ItemPizzaBinding binding;

    public PizzaViewHolder(@NonNull ItemPizzaBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void onBind(PizzaModel pizzaModel) {
        Glide.with(binding.imgPizza).load(pizzaModel.image).into(binding.imgPizza);
        binding.tvName.setText(pizzaModel.name);
        binding.tvDesc.setText(pizzaModel.desc);
    }

}

