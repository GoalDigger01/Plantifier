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

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private static  final String Tag = "RecyclerView";
    private Context mContext;
    private ArrayList<TopPicksDbRetrieve> TopPicksDBList;




    public RecyclerAdapter(Context mContext, ArrayList<TopPicksDbRetrieve> topPicksDBList) {
        this.mContext = mContext;
        this.TopPicksDBList = topPicksDBList;


    }


    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_item, parent, false);
        return new ViewHolder(view);



    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

//        TEXTVIEW
        holder.textViewDescription.setText(TopPicksDBList.get(position).getDescription());
        holder.textViewFamily.setText(TopPicksDBList.get(position).getFamily());
        holder.textViewFloweringtime.setText(TopPicksDBList.get(position).getFloweringtime());
        holder.textViewHabitat.setText(TopPicksDBList.get(position).getHabitat());
        holder.textViewName.setText(TopPicksDBList.get(position).getName());
        holder.textViewType.setText(TopPicksDBList.get(position).getType());




//        IMAGE : GLIDE LIBRARY

        Glide.with(mContext).load(TopPicksDBList.get(position).getImageurl())
                .into(holder.imageView);




    }

    @Override
    public int getItemCount() {
        return TopPicksDBList.size();
    }

    public
    class ViewHolder extends RecyclerView.ViewHolder {
//        Widgets

        ImageView imageView;
        TextView  textViewType, textViewName, textViewFamily, textViewFloweringtime, textViewHabitat, textViewDescription;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textViewType = itemView.findViewById(R.id.textviewType);
            textViewName = itemView.findViewById(R.id.textviewName);
            textViewFamily = itemView.findViewById(R.id.textviewFamily);
            textViewFloweringtime = itemView.findViewById(R.id.textviewFloweringtime);
            textViewHabitat = itemView.findViewById(R.id.textviewHabitat);
            textViewDescription = itemView.findViewById(R.id.textviewDescription);
        }
    }

}
