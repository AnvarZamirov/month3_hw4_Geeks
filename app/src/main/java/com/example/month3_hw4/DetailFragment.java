package com.example.month3_hw4;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.month3_hw4.databinding.FragmentDetailBinding;

public class DetailFragment extends Fragment {

    FragmentDetailBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            PizzaModel pizzaModels =
                    (PizzaModel) getArguments().getSerializable("pizza");
            pizzaModels = (PizzaModel) getArguments().getSerializable("pizza");
            binding.tvPizza.setText(pizzaModels.name);
            binding.tvDesc.setText(pizzaModels.desc);
            binding.tvPrice.setText(pizzaModels.price + "$");
            Glide.with(binding.imgPizza).
                    load(pizzaModels.image).into(binding.imgPizza);
        }
    }
}