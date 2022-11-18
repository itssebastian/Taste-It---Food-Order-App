package com.sebastian.tasteit.Adapter;

import android.content.Intent;
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
import com.sebastian.tasteit.Activity.ShowDetailActivity;
import com.sebastian.tasteit.Domain.FoodDomain;
import com.sebastian.tasteit.R;

import java.util.ArrayList;

public class RecommendedAdapter extends RecyclerView.Adapter<RecommendedAdapter.ViewHolder>{
    private final RecyclerInterface recyclerInterface;
    ArrayList<FoodDomain> RecommendedDomains;

    public RecommendedAdapter(ArrayList<FoodDomain> RecommendedDomains,RecyclerInterface recyclerInterface) {
        this.RecommendedDomains = RecommendedDomains;
        this.recyclerInterface = recyclerInterface;
    }

    @NonNull
    @Override
    public RecommendedAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_recommended,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(RecommendedDomains.get(position).getTitle());
        holder.fee.setText(String.valueOf(RecommendedDomains.get(position).getFee()));
        String picUrl="";


        int drawableResourceId=holder.itemView.getContext()
                .getResources().getIdentifier(RecommendedDomains.get(position).getPic(),"drawable",
                        holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.pic);

        holder.addBtn.setOnClickListener(v -> {
            Intent intent = new Intent(holder.itemView.getContext(), ShowDetailActivity.class);
            intent.putExtra("object",RecommendedDomains.get(position));
            holder.itemView.getContext().startActivity(intent);
        });


    }

    @Override
    public int getItemCount() {
        return RecommendedDomains.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        TextView title,fee;
        ImageView pic;
        ImageView addBtn;

        public ViewHolder(@NonNull View itemView)
        {
            super (itemView);
            title=itemView.findViewById(R.id.title);
            pic=itemView.findViewById(R.id.pic);
            fee=itemView.findViewById(R.id.fee);
            addBtn=itemView.findViewById(R.id.addBtn);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(recyclerInterface!=null) {
                        int pos = getAdapterPosition();

                        if(pos!=RecyclerView.NO_POSITION){
                            recyclerInterface.onItemClick2(pos);


                        }
                    }
                }
            });


        }
    }
}
