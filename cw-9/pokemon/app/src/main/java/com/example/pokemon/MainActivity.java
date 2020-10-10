package com.example.pokemon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<pokemon1>  pokemons = new ArrayList<>();

        pokemon1 p1 = new pokemon1 ("squirtle",R.drawable.images,260,350,610);
        pokemon1 p2 = new pokemon1("pikachu",R.drawable.countrydetailpokemon,200,300,600);
        pokemon1 p3 = new pokemon1("piplup",R.drawable.piplup,233,100,333);
        pokemon1 p4 = new pokemon1 ("butter free",R.drawable.butterfree,460,250 ,710);
        pokemon1 p5 = new pokemon1("venusaur",R.drawable.venusaur,300,200,500);
        pokemon1 p6 = new pokemon1("sand shrew",R.drawable.sandshrew,100,200,300);

        pokemons.add(p1);
        pokemons.add(p2);
        pokemons.add(p3);
        pokemons.add(p4);
        pokemons.add(p5);
        pokemons.add(p6);

        RecyclerView recyclerView = findViewById(R.id.RecyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager kj = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(kj);

        pokemonadapter pa = new pokemonadapter(pokemons,this);
        recyclerView.setAdapter(pa);
    }
}