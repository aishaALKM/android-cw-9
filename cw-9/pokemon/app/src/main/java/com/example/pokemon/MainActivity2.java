package com.example.pokemon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle b = getIntent().getExtras();
        pokemon1 p= (pokemon1) b.getSerializable("pokemon1");

        ImageView img = findViewById(R.id.imageView3);
        TextView name = findViewById(R.id.textView5);
        TextView attack = findViewById(R.id.textView7);
        TextView def = findViewById(R.id.textView8);

        img.setImageResource(p.getImage());
        name.setText(p.getName());
        attack.setText("Attack"+p.getAttack());
        def.setText("Defence"+p.getDefence());
    }
}