package com.example.wordsgame;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class StepAdapter extends RecyclerView.Adapter<StepAdapter.StepViewHolder> {
    private List<Level> lists = new ArrayList<>();

    public StepAdapter(List<Level> levels) {
        lists = levels;
    }
    @NonNull
    @Override
    public StepViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StepViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.step_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull StepViewHolder holder, int position) {
        holder.BindContacts(lists.get(position));
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public class StepViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public StepViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.item_level);
        }

        public void BindContacts(Level level) {
            textView.setText(String.valueOf(level.getId()));
        }
    }
}
