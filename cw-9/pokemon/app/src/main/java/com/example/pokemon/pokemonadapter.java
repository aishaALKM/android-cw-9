package com.example.pokemon;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class pokemonadapter extends RecyclerView.Adapter {
    ArrayList<pokemon1> pArray;
        Context context;

        public pokemonadapter(ArrayList<pokemon1>pArray, Context context){
            this.pArray = pArray;
            this.context = context;
        }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item1,parent,  false);
            ViewHolder kj = new ViewHolder(v);
            return kj;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ((ViewHolder)holder).img.setImageResource(pArray.get(position).getImage());
        ((ViewHolder)holder).total.setText(pArray.get(position).getTotal()+" ");
        ((ViewHolder)holder).name.setText(pArray.get(position).getName());
        ((ViewHolder)holder).view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context,MainActivity2.class);
                i.putExtra("pokemon1",pArray.get(position));
                context.startActivity(i);
            }
        });

        final AlertDialog.Builder builder = new AlertDialog.Builder(context);

        ((ViewHolder) holder).delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setTitle("Delete");
                builder.setMessage("Are you sure you want to delete ?");
                builder.setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        pArray.remove(position);
                        notifyDataSetChanged();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
        }

    @Override
    public int getItemCount() {
        return pArray.size();
    }
     public static class ViewHolder extends RecyclerView.ViewHolder{
            public ImageView img ;
            public TextView name ;
            public TextView total ;
            public View view;
            public ImageView delete ;
         public ViewHolder(@NonNull View itemView) {
             super(itemView);
             view = itemView ;
             img = itemView.findViewById(R.id.imageView);
             name = itemView.findViewById(R.id.textView);
             total = itemView.findViewById(R.id.textView4);
             delete = itemView.findViewById(R.id.imageView2);


         }
     }
}

