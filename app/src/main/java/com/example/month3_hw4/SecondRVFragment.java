package com.example.month3_hw4;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.month3_hw4.databinding.FragmentSecondRVBinding;

public class SecondRVFragment extends Fragment {

    private FragmentSecondRVBinding binding;
    private PizzaModel pizzaModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSecondRVBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            pizzaModel = (PizzaModel) getArguments().getSerializable("pizza");
            displayPizzaDetails();
        }
    }

    private void displayPizzaDetails() {
        if (pizzaModel != null) {
            binding.tvName.setText(pizzaModel.getName());
            binding.tvDesc.setText(pizzaModel.getDesc());
            binding.tvDesc.setText(pizzaModel.getDesc());
            binding.tvPrice.setText(pizzaModel.getPrice() + "$");
            //binding.imgPizza.setImageResource(pizzaModel.image);
            Glide.with(this).load(pizzaModel.getImage()).into(binding.imgPizza);
        }
    }
}
