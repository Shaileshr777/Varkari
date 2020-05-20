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

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder>
{

    private ArrayList<Message> messageArrayList;
    private Context context;


    public MessageAdapter(Context context, ArrayList<Message> messageArrayList) {

        this.messageArrayList=messageArrayList;
        this.context=context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_message, viewGroup, false);
        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

       // viewHolder.textMessage.setText(messageArrayList.get(i).getMessage());
        //viewHolder.textName.setText(messageArrayList.get(i).getName()+"");
        String name=messageArrayList.get(i).getName();
        String message=messageArrayList.get(i).getMessage();


        viewHolder.textName.setText(Html.fromHtml("<font color=\"#40E0D0\">"+name+"&nbsp;&nbsp;</font>" +"<font color=\"white\"><b>"+message+"</b></font>"));
        System.out.println("Messsage--- "+messageArrayList.get(i).getMessage());

        Glide.with(context)
                .load(messageArrayList.get(i).getImage_url())
                .centerCrop()
                .placeholder(R.drawable.user)
                .into(viewHolder.imageProfile);
        /*  if (!messageArrayList.get(i).getImage_url().isEmpty())
        {


        }*/



    }

    @Override
    public int getItemCount() {
        return messageArrayList.size();
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
