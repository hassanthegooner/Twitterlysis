package com.gre.hassanshah.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by hassanshah on 01/02/2016.
 */
public class TimelineFragment extends Fragment {

    public TimelineFragment(){
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle args) {
        View view = inflater.inflate(R.layout.timeline_fragment, container, false);
        return view;
    }

    public interface OnTimelineDisplayListener {
        // TODO: Update argument type and nam
    }


}
