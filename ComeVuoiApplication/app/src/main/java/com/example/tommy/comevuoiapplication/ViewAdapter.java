package com.example.tommy.comevuoiapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ViewAdapter extends  RecyclerView.Adapter<ViewAdapter.ViewHolder>{
    private final String TAG = "RecycleViewAdapter";
    private ArrayList<String> nameImageList = new ArrayList<>();
    private ArrayList<String> imageList = new ArrayList<>();
    private Context context;

    public ViewAdapter(ArrayList<String> nameImageList, ArrayList<String> imageList, Context context) {
        this.nameImageList = nameImageList;
        this.imageList = imageList;
        this.context = context;
    }


    public ViewHolder onCreateViewHolder( ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitems, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        Glide.with(context).asBitmap().load(imageList.get(i)).into(viewHolder.image);
        viewHolder.imageName.setText(nameImageList.get(i));
        viewHolder.parentPalyout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, nameImageList.get(i), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return nameImageList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView image;
        TextView imageName;
        RelativeLayout parentPalyout;

        public ViewHolder( View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.text);
            parentPalyout = itemView.findViewById(R.id.parentLayout);
        }
    }
}
