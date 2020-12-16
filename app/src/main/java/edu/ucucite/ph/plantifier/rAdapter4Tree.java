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

public class rAdapter4Tree extends RecyclerView.Adapter<rAdapter4Tree.ImageViewHolder>{
    private Context mContext;

    private List<TreesDB> mTreeDB;

    public rAdapter4Tree(Context context, List<TreesDB> treeDB){
        mContext = context;
        mTreeDB = treeDB;

    }

    public rAdapter4Tree(Flowers context, ArrayList<FlowersDB> mFlowerDB) {
    }


    @NonNull
    @Override
    public rAdapter4Tree.ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.layout_item, parent, false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        TreesDB treesDBS = mTreeDB.get(position);
        holder.textViewType.setText(treesDBS.getType());
        holder.textViewName.setText(treesDBS.getName());
        holder.textViewHabitat.setText(treesDBS.getHabitat());
        holder.textViewFamily.setText(treesDBS.getFamily());
        holder.textViewFloweringTime.setText(treesDBS.getFloweringTime());
        holder.textViewDescription.setText(treesDBS.getDescription());


        Glide.with(mContext).load(treesDBS.getImageurl())
                .into(holder.imageView);

    }



    @Override
    public int getItemCount() {
        return mTreeDB.size()   ;
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
