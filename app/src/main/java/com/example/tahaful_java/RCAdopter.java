package com.example.tahaful_java;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RCAdopter extends RecyclerView.Adapter<RCAdopter.RCViewholder> {

    Context context;
    ArrayList<RCModel> modelArrayList;


    public <listener> RCAdopter(Context context, ArrayList<RCModel> modelArrayList) {
        this.context = context;
        this.modelArrayList = modelArrayList;
       ;
    }
    public interface OnItemClickListener {
        void onItemClick(int position);
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
        RCModel rcModel=modelArrayList.get(position);

        holder.uniName.setText(rcModel.name);
        holder.uniLocation.setText(rcModel.country);

    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public class  RCViewholder extends RecyclerView.ViewHolder {

    TextView uniName;
    TextView uniLocation;
    public RCViewholder(@NonNull View itemView) {

        super(itemView);
        uniName= itemView.findViewById(R.id.UniversityName);
        uniLocation= itemView.findViewById(R.id.UniversityState);
    }
}
}
