package com.example.tahaful_java.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tahaful_java.Activities.Details;
import com.example.tahaful_java.Models.UniversityModel;
import com.example.tahaful_java.R;
import com.example.tahaful_java.Models.RCModel;

import java.util.ArrayList;

public class RCAdapter extends RecyclerView.Adapter<RCAdapter.RCViewholder> {

    Context context;
    ArrayList<UniversityModel> modelArrayList;

    public RCAdapter(Context context, ArrayList<UniversityModel> modelArrayList) {
        this.context = context;
        this.modelArrayList = modelArrayList;

    }

    @NonNull
    @Override
    public RCViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.item_university,parent,false);
        return new RCViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RCViewholder holder, int position) {
        ArrayList<UniversityModel>  rcModel = modelArrayList;

        holder.uniName.setText(rcModel.get(position).getName());
        holder.uniLocation.setText(rcModel.get(position).getCountry());

        holder.cvItem.setOnClickListener(v -> {
            context.startActivity(new Intent(context, Details.class).putExtra("country_code",rcModel.get(position).getAlpha_two_code())
                    .putExtra("country",rcModel.get(position).getCountry())
                    .putExtra("university_name",rcModel.get(position).getName())
                    .putExtra("web_page",rcModel.get(position).getWeb_pages().get(0))
            );
        });
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public class  RCViewholder extends RecyclerView.ViewHolder {

    TextView uniName,uniLocation;
    ImageView ivArrow;

    CardView cvItem;
    public RCViewholder(@NonNull View itemView) {

        super(itemView);
        uniName= itemView.findViewById(R.id.UniversityName);
        uniLocation= itemView.findViewById(R.id.UniversityState);
        ivArrow= itemView.findViewById(R.id.ivArrow);
        cvItem = itemView.findViewById(R.id.cvItem);
    }
}
}
