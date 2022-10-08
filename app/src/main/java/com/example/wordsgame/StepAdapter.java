package com.example.wordsgame;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class StepAdapter extends RecyclerView.Adapter<StepAdapter.StepViewHolder> {
    private List<Level> lists = new ArrayList<>();
    private OnClickedItemListener<Level> onClickedItemListener;

    public StepAdapter(List<Level> levels, OnClickedItemListener<Level> onClickedItemListener)
    {
        lists = levels;
        this.onClickedItemListener = onClickedItemListener;
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
        private SquareItems squareItem;

        public StepViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.item_level);
            squareItem = itemView.findViewById(R.id.main_item_level);
        }

        public void BindContacts(Level level) {
            textView.setText(String.valueOf(level.getId()));
            squareItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickedItemListener.onClickedStep(level, getAdapterPosition());
                }
            });
        }
    }
}
