package com.example.kripto.Adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kripto.R;
import com.example.kripto.model.Cryto;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerHolder> {

    private ArrayList<Cryto> crytolist;
    private String[] colors={"#0098ff","#ff7300","#ffe100","#008080","#ff5733","#ff33D4","#33fff6","#145653"};

    public RecyclerViewAdapter(ArrayList<Cryto> crytolist) {
        this.crytolist = crytolist;
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_layout,parent,false);
        return new RecyclerHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int position) {

        holder.bind(crytolist.get(position),colors,position);

    }

    @Override
    public int getItemCount() {
        return crytolist.size();
    }

    public class RecyclerHolder extends RecyclerView.ViewHolder {




        TextView textName;
        TextView textPrice;



        public RecyclerHolder(@NonNull View itemView) {
            super(itemView);




        }
        public void bind(Cryto cryto, String[] colors, Integer position){
            itemView.setBackgroundColor(Color.parseColor(colors[position % 8]));
            textName=itemView.findViewById(R.id.text_name);
            textPrice=itemView.findViewById(R.id.text_price);
            textName.setText(cryto.currency);
            textPrice.setText(cryto.price);



        }
    }
}
