package com.example.myapplication5;
import static com.example.myapplication5.memry.*;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

public class hp  extends RecyclerView.Adapter<hp.ViewHolder>{
    private final LayoutInflater inflater;

    hp(Context context) {
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public hp.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(hp.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        State state = hp_p.get(position);
        holder.flagView.setImageResource(state.getFlagResource());
    }


    @Override
    public int getItemCount() {
        return hp_p.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView flagView;
        ViewHolder(View view){
            super(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
            flagView = view.findViewById(R.id.flag);
        }
    }

}