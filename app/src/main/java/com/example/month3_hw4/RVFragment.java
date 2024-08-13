package com.example.month3_hw4;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.month3_hw4.databinding.FragmentRVBinding;
import java.util.ArrayList;

public class RVFragment extends Fragment implements OnItemClick {

    private FragmentRVBinding binding;
    private PizzaAdapter adapter;
    private ArrayList<PizzaModel> pizzaModel = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRVBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadData();
        adapter = new PizzaAdapter(pizzaModel, this);
        binding.rvPizza.setAdapter(adapter);
    }

    private void loadData() {
        pizzaModel.add(new PizzaModel("Peperoni", "https://www.allrecipes.com/thmb/9UTj7kZBJDqory0cdEv_bw6Ef_0=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/48727-Mikes-homemade-pizza-DDMFS-beauty-2x1-BG-2976-d5926c9253d3486bbb8a985172604291.jpg", "Peperoni god pizza", "5"));
        pizzaModel.add(new PizzaModel("Margarita", "https://imag.bonviveur.com/pizza-margarita.jpg", "Margarita god pizza", "5"));
        pizzaModel.add(new PizzaModel("kola", "https://upload.wikimedia.org/wikipedia/commons/thumb/c/cf/Tumbler_of_cola_with_ice.jpg/274px-Tumbler_of_cola_with_ice.jpg", "Kola with USA", "5"));
        pizzaModel.add(new PizzaModel("Italian", "https://www.allrecipes.com/thmb/9UTj7kZBJDqory0cdEv_bw6Ef_0=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/48727-Mikes-homemade-pizza-DDMFS-beauty-2x1-BG-2976-d5926c9253d3486bbb8a985172604291.jpg", "Italian god pizza", "5"));
        pizzaModel.add(new PizzaModel("Asian", "https://www.allrecipes.com/thmb/9UTj7kZBJDqory0cdEv_bw6Ef_0=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/48727-Mikes-homemade-pizza-DDMFS-beauty-2x1-BG-2976-d5926c9253d3486bbb8a985172604291.jpg", "Asian god pizza", "5"));
    }

    @Override
    public void onClick(int position) {
        PizzaModel pizza = pizzaModel.get(position);
        Bundle bundle = new Bundle();
        bundle.putSerializable("pizza", pizza);
        SecondRVFragment fragment = new SecondRVFragment();
        fragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.ct_title, fragment)
                .addToBackStack(null)
                .commit();
    }
}
