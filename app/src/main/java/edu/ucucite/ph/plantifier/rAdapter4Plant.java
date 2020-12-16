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

import java.util.ArrayList;
import java.util.List;

public class rAdapter4Plant extends RecyclerView.Adapter<rAdapter4Plant.ImageViewHolder>{
    private Context mContext;

    private List<PlantDB> mPlantDB;

    public rAdapter4Plant(Context context, ArrayList<PlantDB> plantsDB){
        mContext = context;
        mPlantDB = plantsDB;

}

    public rAdapter4Plant( ArrayList<TreesDB> mTreeDB) {
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.layout_item, parent, false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        PlantDB plantDBS = mPlantDB.get(position);
        holder.textViewType.setText(plantDBS.getType());
        holder.textViewName.setText(plantDBS.getName());
        holder.textViewHabitat.setText(plantDBS.getHabitat());
        holder.textViewFamily.setText(plantDBS.getFamily());
        holder.textViewFloweringTime.setText(plantDBS.getFloweringTime());
        holder.textViewDescription.setText(plantDBS.getDescription());


        Glide.with(mContext).load(plantDBS.getImageurl())
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return mPlantDB.size()   ;
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