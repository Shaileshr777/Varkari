package com.standard.varkari;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.alespero.expandablecardview.ExpandableCardView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ExpandableCardView card = findViewById(R.id.general_profile);

        card.setOnExpandedListener(new ExpandableCardView.OnExpandedListener() {
            @Override
            public void onExpandChanged(View v, boolean isExpanded) {
                Toast.makeText(getApplicationContext(), isExpanded ? "Expanded!" : "Collapsed!", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
