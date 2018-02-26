package com.malo.androiddev.MemoFragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.malo.androiddev.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MemoDetailFragment extends Fragment {


    public MemoDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_memo_detail, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        TextView detailView = getView().findViewById(R.id.text_view_detail_memo);

        detailView.setText(getArguments().getString("libelle"));
    }
}
