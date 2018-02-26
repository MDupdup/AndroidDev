package com.malo.androiddev;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.malo.androiddev.MemoFragments.MemoDetailFragment;
import com.malo.androiddev.MemoFragments.MemoFragment;

/**
 * Created by Malo on 23/02/2018.
 */

public class MemoActivity extends AppCompatActivity {

    GestureDetector gestureDetector;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);
    }

    public void afficherMemo(String libelle) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        MemoDetailFragment detailFragment = new MemoDetailFragment();

        Bundle bundle = new Bundle();

        bundle.putString("libelle",libelle);
        detailFragment.setArguments(bundle);

        fragmentTransaction.replace(R.id.conteneur_detail,detailFragment,"detail");

        fragmentTransaction.commit();

    }
}
