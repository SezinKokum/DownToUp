package com.tatlicilar.downtoup;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyHolder> implements Filterable {

    Context c;
    ArrayList<AramaKisiler> kisiler,filterList;
    CustomFilter filter;
    public MyAdapter(Context ctx,ArrayList<AramaKisiler> kisiler)
    {
        this.c=ctx;
        this.kisiler=kisiler;
        this.filterList=kisiler;
    }
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //CONVERT XML TO VIEW ONBJ
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.model,null);
        //HOLDER
        MyHolder holder=new MyHolder(v);
        return holder;
    }
    //DATA BOUND TO VIEWS
    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        //BIND DATA
        holder.posTxt.setText(kisiler.get(position).getPos());
        holder.nameTxt.setText(kisiler.get(position).getName());
        holder.img.setImageResource(kisiler.get(position).getImg());
        //IMPLEMENT CLICK LISTENET
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                Snackbar.make(v,kisiler.get(pos).getName(),Snackbar.LENGTH_SHORT).show();
            }
        });
    }
    //GET TOTAL NUM OF PLAYERS
    @Override
    public int getItemCount() {
        return kisiler.size();
    }
    //RETURN FILTER OBJ
    @Override
    public Filter getFilter() {
        if(filter==null)
        {
            filter=new CustomFilter(filterList,this);
        }
        return filter;
    }
}
