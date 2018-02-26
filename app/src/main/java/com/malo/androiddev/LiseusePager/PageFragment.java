package com.malo.androiddev.LiseusePager;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.malo.androiddev.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PageFragment extends Fragment {

    TextView liseuseView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        LiseuseDialog liseuseDialog = new LiseuseDialog();
        liseuseDialog.show(getActivity().getSupportFragmentManager(),"yolo");

        liseuseView = getView().findViewById(R.id.liseuse_content);

        liseuseView.setOnClickListener();
    }
}
