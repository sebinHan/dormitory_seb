package com.example.eunbee.help_dormitory;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Created by Eun bee on 2016-11-08.
 */

public class FragmentNoticeSchedule extends Fragment {
    public FragmentNoticeSchedule(){}
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        Log.i("FragmentNoticeSchedule"," ");
        return (RelativeLayout)inflater.inflate(R.layout.fragment_notice_schedule, container, false);
    }
}
