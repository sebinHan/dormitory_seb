package com.example.eunbee.help_dormitory;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by Eun bee on 2016-11-01.
 */

public class FragmentNotice extends Fragment {
    ImageView imgVSchedule,imgVRule;
    FragmentViewActivity fva;
    ViewGroup container;
    FragmentTransaction tr;
    LinearLayout linear;
    RelativeLayout relative;
    public FragmentNotice(){}
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //new DialogActivity();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity=(Activity)context;
        fva=(FragmentViewActivity)activity;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        this.container=container;
        FrameLayout v=(FrameLayout) inflater.inflate(R.layout.fragment_notice, container, false);
        imgVSchedule=(ImageView)v.findViewById(R.id.schedule);
        linear=(LinearLayout)v.findViewById(R.id.notice1);
        relative=(RelativeLayout)v.findViewById(R.id.notice_schedule);
        imgVSchedule.setOnClickListener(nHandler);
        imgVRule=(ImageView)v.findViewById(R.id.rule);
        imgVRule.setOnClickListener(nHandler);
        return v;
    }
    View.OnClickListener nHandler=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FragmentManager fm = getFragmentManager();
            tr = fm.beginTransaction();



            switch (v.getId()){
                case R.id.schedule:
                    Log.i("schedule","aaaaaaa");
/*                    tr.replace(R.id.notice1, new FragmentNoticeSchedule());
                    tr.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    tr.addToBackStack(null);
                    tr.commit();*/
                    linear.setVisibility(View.GONE);
                    relative.setVisibility(View.VISIBLE);
                    break;
                case R.id.rule:
                    Log.i("rule","bbbbbb");
                    new FragmentNoticeRule();
            }
        }
    };
}
