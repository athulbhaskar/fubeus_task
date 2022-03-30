package com.athulsapp.demoapplocation.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.athulsapp.demoapplocation.Model.CoffieModel;
import com.athulsapp.demoapplocation.R;

import java.util.List;


public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context  context;
   List<CoffieModel>  model;

    public Adapter(List<CoffieModel> model, Context context) {
        this.model=model;
        this.context=context;

    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView text,description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text=itemView.findViewById(R.id.text);
            description=itemView.findViewById(R.id.description);
        }
    }


    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View v= LayoutInflater.from(context).inflate(R.layout.row_screen,parent,false);
       return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        CoffieModel coffieModel=model.get(position);
        holder.text.setText(coffieModel.getTitle());
        holder.description.setText(coffieModel.getDescription());

    }

    @Override
    public int getItemCount() {
        return model.size();
    }


}
