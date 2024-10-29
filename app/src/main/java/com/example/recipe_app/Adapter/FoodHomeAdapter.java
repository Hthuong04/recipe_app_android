package com.example.recipe_app.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipe_app.Model.FoodHome;
import com.example.recipe_app.R;

import java.util.List;

public class FoodHomeAdapter extends RecyclerView.Adapter<FoodHomeAdapter.FoodViewHolder> {

    private List<FoodHome> mFoodHome;
    private OnFoodClickListener mListener;

    public void setData(List<FoodHome> list, OnFoodClickListener listener) {
        this.mFoodHome = list;
        this.mListener = listener;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_food, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        FoodHome foodHome = mFoodHome.get(position);
        if (foodHome == null) {
            return;
        }
        holder.imgFood.setImageResource(foodHome.getResourceId());
        holder.tvTitle.setText(foodHome.getTitle());
        holder.tvSave.setText(foodHome.getSave());

        // Bắt sự kiện click
        holder.itemView.setOnClickListener(v -> {
            if (mListener != null) {
                mListener.onFoodClick(foodHome);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (mFoodHome != null) ? mFoodHome.size() : 0;
    }

    public static class FoodViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgFood;
        private TextView tvTitle;
        private TextView tvSave;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFood = itemView.findViewById(R.id.imageView1);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvSave = itemView.findViewById(R.id.tv_save);
        }
    }

    // Interface để xử lý sự kiện click
    public interface OnFoodClickListener {
        void onFoodClick(FoodHome food);
    }
}
