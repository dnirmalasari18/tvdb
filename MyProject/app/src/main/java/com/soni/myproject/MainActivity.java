package com.soni.myproject;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.soni.myproject.model.DataTV;
import com.soni.myproject.model.GuestStar;

import java.util.ArrayList;
import java.util.Arrays;

import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv;
    private RecyclerView.Adapter rva;
    private RecyclerView.LayoutManager rvlm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        myRef.addValueEventListener(new ValueEventListener() {
            ArrayList<DataTV> dtvs = new ArrayList<>();

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                dtvs.clear();
                for(DataSnapshot ds : dataSnapshot.getChildren())
                {
                    DataTV value = ds.getValue(DataTV.class);
                    dtvs.add(value);
                }
                rva = new MyAdapter(dtvs,getApplicationContext());
                rv.setAdapter(rva);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        rv = findViewById(R.id.recyclerview);
        rv.setHasFixedSize(true);

        rvlm = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(rvlm);
    }
}
