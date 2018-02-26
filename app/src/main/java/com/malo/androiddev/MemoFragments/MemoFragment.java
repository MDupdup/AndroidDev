package com.malo.androiddev.MemoFragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.malo.androiddev.MemoActivity;
import com.malo.androiddev.NotesView.Note;
import com.malo.androiddev.NotesView.NotesAdapter;
import com.malo.androiddev.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MemoFragment extends Fragment implements RecyclerView.OnItemTouchListener {

    GestureDetector gestureDetector;

    EditText editText;
    Button buttonSubmit;

    List<Note> listNotes = new ArrayList<>();
    NotesAdapter notesAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_memo, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        getActivity().setTitle("Liste de notes");

        RecyclerView recyclerView = getView().findViewById(R.id.liste_notes);
        editText = getView().findViewById(R.id.add_note);
        buttonSubmit = getView().findViewById(R.id.submit_note);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        listNotes.add(new Note("Bonjour"));
        listNotes.add(new Note("Au revoir"));

        notesAdapter = new NotesAdapter(listNotes);
        recyclerView.setAdapter(notesAdapter);

        gestureDetector = new GestureDetector(getContext(),
                new GestureDetector.SimpleOnGestureListener() {
                    @Override
                    public boolean onSingleTapUp(MotionEvent event) {
                        return true;
                    }
                });

        recyclerView.addOnItemTouchListener(this);
    }

    public void addItem(View view) {
        if(!editText.getText().toString().isEmpty()) {
            listNotes.add(new Note(editText.getText().toString()));
            editText.setText("");
            notesAdapter.notifyDataSetChanged();
        } else {
            Toast.makeText(getContext(),"Veuillez entrer un libellé !", Toast.LENGTH_SHORT).show();
        }
    }

    public void deleteItem(View view) {

    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent)
    {
        if (gestureDetector.onTouchEvent(motionEvent))
        {
            View child = recyclerView.findChildViewUnder(motionEvent.getX(),
                    motionEvent.getY());
            if (child != null)
            {
                int position = recyclerView.getChildAdapterPosition(child);
                ((MemoActivity) getActivity()).afficherMemo(listNotes.get(position).getIntituleNote());

                return true;
            }
        }
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

}
