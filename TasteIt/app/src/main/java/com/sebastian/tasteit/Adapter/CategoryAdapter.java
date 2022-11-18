package com.sebastian.tasteit.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sebastian.tasteit.Activity.RecyclerInterface;
import com.sebastian.tasteit.Domain.CategoryDomain;
import com.sebastian.tasteit.R;

import java.util.ArrayList;

public  class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder>{
    private final RecyclerInterface  recyclerInterface;
    ArrayList<CategoryDomain> categoryDomains;

    public CategoryAdapter(ArrayList<CategoryDomain> categoryList,RecyclerInterface recyclerInterface) {
        this.categoryDomains= categoryList;
        this.recyclerInterface = recyclerInterface;

    }


    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category,parent,false);
        return new ViewHolder(inflate,recyclerInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.categoryName.setText(categoryDomains.get(position).getTitle());
        String picUrl="";

        switch(position){

            case 0:{
                picUrl="cat_1";
                break;
            }
            case 1:{
                picUrl="cat_2";
                break;
            }
            case 2:{
                picUrl="cat_3";
                break;
            }
            case 3:{
                picUrl="cat_4";
                break;
            }
            case 4:{
                picUrl="cat_5";
                break;
            }
        }
        int drawableResourceId=holder.itemView.getContext()
                .getResources().getIdentifier(picUrl,"drawable",holder.itemView
                        .getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.categoryPic);


    }

    @Override
    public int getItemCount() {
        return categoryDomains.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        TextView categoryName;
        ImageView categoryPic;
        ConstraintLayout mainLayout;

        public ViewHolder(@NonNull View itemView,RecyclerInterface recyclerInterface)
        {
            super (itemView);

            categoryName=itemView.findViewById(R.id.categoryName);
            categoryPic=itemView.findViewById(R.id.categoryPic);
            mainLayout=itemView.findViewById(R.id.mainLayout);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(recyclerInterface!=null) {
                        int pos = getAdapterPosition();

                        if(pos!=RecyclerView.NO_POSITION){
                            recyclerInterface.onItemClick(pos);


                        }
                    }
                }
            });

        }
    }
}
