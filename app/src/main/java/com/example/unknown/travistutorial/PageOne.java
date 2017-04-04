package com.example.unknown.travistutorial;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PageOne extends android.support.v4.app.Fragment {

    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_page_one, container, false);
        textView = (TextView)view.findViewById(R.id.tvFragment);
        Bundle bundle = getArguments();
        String msg = Integer.toString(bundle.getInt("Count"));
        textView.setText("This is the" + msg + "th swipe view page");
        return view;
    }
}

