package com.example.eunbee.help_dormitory;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eunbee.help_dormitory.models.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Comment;
import org.w3c.dom.Text;

/**
 * Created by Eun bee on 2016-11-01.
 */

public class FragmentTimeBoard extends Fragment{
    private static final String TAG = "FragmentTimeBoard";
    ImageView imgV;
    String str;
    TextView tx;
    private DatabaseReference mDatabase;
    public FragmentTimeBoard(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v=inflater.inflate(R.layout.fragment_timeboard, container, false);
        imgV=(ImageView)v.findViewById(R.id.add);
        mDatabase= FirebaseDatabase.getInstance().getReference();

        mDatabase.child("data").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                str=dataSnapshot.getValue(String.class);
                Log.d("바보", "내용은" + str);
               // tx.setText(str);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        imgV.setOnClickListener(mHandler);

        return v;

    }

    View.OnClickListener mHandler=new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            FragmentManager fm = getFragmentManager();
            FragmentTransaction tr = fm.beginTransaction();
            /*Fragment prev = fm.findFragmentByTag("dialog");
            if(prev!=null){
                tr.remove(prev);
            }*/
            FragmentSetTime dialog = new FragmentSetTime();
            dialog.show(tr,"dialog");
        }
    };
    public String getUid() {
        return FirebaseAuth.getInstance().getCurrentUser().getUid();
    }

}
