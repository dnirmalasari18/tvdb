package com.soni.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.soni.myproject.model.DataTV;
import com.soni.myproject.model.GuestStar;

import java.util.ArrayList;
import java.util.Arrays;

public class TestFB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_fb);
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        //DatabaseReference myRef = database.getReference("message");
        GuestStar gs = new GuestStar(1,"iko uwais",false);
        GuestStar gs1 = new GuestStar(2,"angelina joli",true);
        GuestStar gs2 = new GuestStar(3,"Tom krus",false);
        GuestStar gsa[] = {gs1,gs2};
        ArrayList<GuestStar> gss = new ArrayList<>(Arrays.asList(gsa));

        DataTV dtv = new DataTV(1,2,"azab","2014-01-01",gss,"punjabi",4.9, 1 );

        GuestStar gsb[] = {gs1,gs2,gs};
        gss = new ArrayList<>(Arrays.asList(gsb));
        DataTV dtv1 = new DataTV(2,4,"tukang bubur","2015-01-01",gss,"rahmat",3.9, 1);

        DatabaseReference myRef = database.getReference("1");
        myRef.setValue(dtv);
        myRef = database.getReference("2");
        myRef.setValue(dtv1);
        myRef = database.getReference();

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
               //String value = dataSnapshot.getValue(String.class);
                TextView tv = findViewById(R.id.textView);
                tv.setText("");

                for(DataSnapshot ds : dataSnapshot.getChildren())
                {
                    DataTV value = ds.getValue(DataTV.class);
                    tv.append(value.getId()+"\n");
                    tv.append(value.getEpisodeName()+"\n");
                    tv.append(value.getRating()+"\n");
                    tv.append(value.getDirector()+"\n");
                    tv.append("===============================\n");
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }
}
