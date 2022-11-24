package com.example.submission_2;

import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>  {

    private ArrayList<DataModel> dataSet;
    private  ItemClickListener mItemListener;

    public CustomAdapter(ArrayList<DataModel> dataSet,ItemClickListener itemClickListener) {

        this.dataSet = dataSet;
        this.mItemListener = itemClickListener;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder  {
        CardView cardView;
        TextView textViewName;
        TextView textViewDesc;
        ImageView imageViewIcon;

        public MyViewHolder (View itemView )
        {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.card_view);
            textViewName = ( TextView) itemView.findViewById(R.id.textViewName);
            textViewDesc = ( TextView) itemView.findViewById(R.id.textViewDesc);
            imageViewIcon = (ImageView) itemView.findViewById(R.id.MyImageView);

        }

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view = LayoutInflater.from(parent.getContext() ).inflate(R.layout.cards_layout , parent ,false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder,  int listPosition) {

        TextView textViewName = viewHolder.textViewName;
        TextView textViewDesc = viewHolder.textViewDesc;
        ImageView imageView = viewHolder.imageViewIcon;
        CardView cardView = viewHolder.cardView;

        textViewName.setText(dataSet.get(listPosition).getName());
        textViewDesc.setText(dataSet.get(listPosition).getDesc());
        imageView.setImageResource(dataSet.get(listPosition).getImage());

        viewHolder.itemView.setOnClickListener(view->
                mItemListener.onItemClick(dataSet.get(listPosition)));

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public interface  ItemClickListener{
        void onItemClick(DataModel dataModel);
    }
}
