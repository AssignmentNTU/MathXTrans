package com.example.edwardsujono.mathxtrans.search;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.edwardsujono.mathxtrans.R;

import java.util.ArrayList;


public class SearchAdaptor extends RecyclerView.Adapter<SearchAdaptor.SearchViewHolder> {

    private ArrayList<Object> list;

    public SearchAdaptor(ArrayList<Object> list){
        this.list = list;
    }

    @Override
    public SearchViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_layout_search, viewGroup, false);
        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SearchViewHolder holder, int position) {
        // there is no implementation yet for this

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public static class SearchViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;

        public SearchViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.cv_search);
        }
    }

}
