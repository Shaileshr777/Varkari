package com.standard.varkari.adapters;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.standard.varkari.R;
import com.standard.varkari.model.Message;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MessageListAdapter extends RecyclerView.Adapter<MessageListAdapter.ViewHolder>
{

    private ArrayList<Message> messageArrayList;
    private Context context;


    public MessageListAdapter(Context context, ArrayList<Message> messageArrayList) {

        this.messageArrayList=messageArrayList;
        this.context=context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    class ViewHolder extends RecyclerView.ViewHolder{

        private CircleImageView imageProfile;
        private TextView textMessage,textName;


        ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageProfile=itemView.findViewById(R.id.ivImage);
            // textMessage=itemView.findViewById(R.id.tvMessage);
            textName=itemView.findViewById(R.id.tvName);

        }
    }
}
