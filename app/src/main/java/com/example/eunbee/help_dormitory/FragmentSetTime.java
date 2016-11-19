package com.example.eunbee.help_dormitory;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eunbee.help_dormitory.models.Post;
import com.example.eunbee.help_dormitory.models.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Eun bee on 2016-11-07.
 */

public class FragmentSetTime extends DialogFragment {
    private static final String TAG = "FragmentSetTime";
    private static final String REQUIRED = "Required";
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    TextView text;

    String str="";
    String notice;
    String date="";

    int year, month, day;
    Button ok_btn;

    @NonNull
    @Override

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.activity_dialog);


        ok_btn = (Button)dialog.findViewById(R.id.ok);
        ok_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                notice = ((EditText)dialog.findViewById(R.id.dialog_work)).getText().toString();
                GregorianCalendar calendar = new GregorianCalendar();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH)+1;
                day= calendar.get(Calendar.DAY_OF_MONTH)+1;
                Log.i(notice+","+year+","+month+","+day," ");
                User user = new User(notice,year,month,day);
                databaseReference.child("DoItff").push().setValue(user);

                dismiss();
            }
        });


        return dialog;


    }
}