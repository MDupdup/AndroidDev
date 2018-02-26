package com.malo.androiddev.NotesView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.malo.androiddev.R;

import java.util.List;

/**
 * Created by Malo on 22/02/2018.
 */

public class NotesAdapter extends RecyclerView.Adapter<NotesViewHolder>{

    private List<Note> listNotes = null;

    public NotesAdapter(List<Note> listNotes) {
        this.listNotes = listNotes;
    }

    @Override
    public NotesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewNote = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_notes,parent,false);
        return new NotesViewHolder(viewNote);
    }

    @Override
    public void onBindViewHolder(NotesViewHolder holder, int position) {
        holder.getTextViewLibelleNote().setText(listNotes.get(position).getIntituleNote());
    }

    @Override
    public int getItemCount() {
        return listNotes.size();
    }
}
