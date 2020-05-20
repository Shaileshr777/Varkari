package com.standard.varkari;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.alespero.expandablecardview.ExpandableCardView;

public class ProfileActivity extends AppCompatActivity{

    ExpandableCardView card_primary;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.layout_profile);

            card_primary=(ExpandableCardView)findViewById(R.id.primary_speciality);
/*
            card_primary.post(new Runnable() {
                @Override
                public void run() {
                    card_primary.scrollTo(0, card_primary.getBottom());
                }
            });*/
        }

}
