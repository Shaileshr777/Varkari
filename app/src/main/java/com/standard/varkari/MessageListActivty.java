package com.standard.varkari;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.standard.varkari.adapters.MessageAdapter;
import com.standard.varkari.model.Message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MessageListActivty extends AppCompatActivity {

    ImageButton btnSend;
    EditText textMessage;
    private DatabaseReference mDatabase;
    RecyclerView recyclerView;
    ArrayList<Message> msgArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_list);

        btnSend=findViewById(R.id.btnSend);
        textMessage=findViewById(R.id.textMessage);
        recyclerView=findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


        //fethMessages();
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // sendMessage();
                //
            }
        });

    }

    public void fethMessages()
    {
        mDatabase.child("Messages").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                msgArrayList=new ArrayList<>();

                System.out.println("Datasnapshot  "+dataSnapshot);
                for (DataSnapshot ds:dataSnapshot.getChildren())
                {
                    Message message=ds.getValue(Message.class);
                    msgArrayList.add(message);
                }

                int resId = R.anim.layoutanimation;
                LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getApplicationContext(), resId);
                MessageAdapter messageAdapter = new MessageAdapter(getApplicationContext(), msgArrayList);
                recyclerView.setLayoutAnimation(animation);

                recyclerView.setAdapter(messageAdapter);
                //if (msgArrayList.size())
                //recyclerView.smoothScrollToPosition(msgArrayList.size()-1);
                messageAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void sendMessage(String text,String url)
    {
        String key = mDatabase.child("Event1").push().getKey();
        // String new_message = text.replaceAll(ProfanityFilter.censorWords(ProfanityFilter.ENGLISH), ":)");

        Message message=new Message("userName",url,text);
        Map<String, Object> postValues = message.toMap();

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("Messages/" + key, postValues);

        mDatabase.updateChildren(childUpdates);

        System.out.println("Chat messages "+text);

    }
}
