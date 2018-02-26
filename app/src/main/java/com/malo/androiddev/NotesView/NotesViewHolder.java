package com.malo.androiddev.NotesView;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.malo.androiddev.R;

/**
 * Created by Malo on 22/02/2018.
 */

public class NotesViewHolder extends RecyclerView.ViewHolder {

    private TextView textViewLibelleNote = null;

    public NotesViewHolder(View itemView) {

        super(itemView);

        textViewLibelleNote = itemView.findViewById(R.id.libelle_note);
    }

    public TextView getTextViewLibelleNote() {
        return textViewLibelleNote;
    }
}
