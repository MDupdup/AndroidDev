package com.malo.androiddev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.malo.androiddev.NotesView.Note;
import com.malo.androiddev.NotesView.NotesAdapter;

import java.util.ArrayList;
import java.util.List;

public class NotesActivity extends AppCompatActivity implements RecyclerView.OnItemTouchListener{

    GestureDetector gestureDetector;

    EditText editText;
    Button buttonSubmit;

    List<Note> listNotes = new ArrayList<>();
    NotesAdapter notesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        setTitle("Liste de notes");

        RecyclerView recyclerView = findViewById(R.id.liste_notes);
        editText = findViewById(R.id.add_note);
        buttonSubmit = findViewById(R.id.submit_note);


        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listNotes.add(new Note("Bonjour"));
        listNotes.add(new Note("Au revoir"));

        notesAdapter = new NotesAdapter(listNotes);
        recyclerView.setAdapter(notesAdapter);

        gestureDetector = new GestureDetector(this,
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
            Toast.makeText(NotesActivity.this,"Veuillez entrer un libellé !", Toast.LENGTH_SHORT).show();
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
                int position = recyclerView.getChildAdapterPosition(child)+1;
                Toast.makeText(NotesActivity.this,"Position n°" + position,Toast.LENGTH_SHORT).show();
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
