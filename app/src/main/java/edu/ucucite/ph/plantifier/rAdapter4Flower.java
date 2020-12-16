package edu.ucucite.ph.plantifier;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class rAdapter4Flower extends RecyclerView.Adapter<rAdapter4Flower.ImageViewHolder>{
    private Context mContext;

    private List<FlowersDB> mFlowerDB;

    public rAdapter4Flower(Context context, List<FlowersDB> flowerDB){
        mContext = context;
        mFlowerDB = flowerDB;
}

    @NonNull
    @Override
    public rAdapter4Flower.ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.layout_item, parent, false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        FlowersDB flowersDBS = mFlowerDB.get(position);
        holder.textViewType.setText(flowersDBS.getType());
        holder.textViewName.setText(flowersDBS.getName());
        holder.textViewHabitat.setText(flowersDBS.getHabitat());
        holder.textViewFamily.setText(flowersDBS.getFamily());
        holder.textViewFloweringTime.setText(flowersDBS.getFloweringTime());
        holder.textViewDescription.setText(flowersDBS.getDescription());


        Glide.with(mContext).load(flowersDBS.getImageurl())
                .into(holder.imageView);
    }





    @Override
    public int getItemCount() {
        return mFlowerDB.size()   ;
    }


    public class ImageViewHolder extends  RecyclerView.ViewHolder {
        public TextView textViewType, textViewName, textViewHabitat, textViewFamily, textViewDescription, textViewFloweringTime;
        public ImageView imageView;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.textviewName);
            textViewType = itemView.findViewById(R.id.textviewType);
            textViewHabitat = itemView.findViewById(R.id.textviewHabitat);
            textViewFamily = itemView.findViewById(R.id.textviewFamily);
            textViewFloweringTime = itemView.findViewById(R.id.textviewFloweringtime);
            textViewDescription = itemView.findViewById(R.id.textviewDescription);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
