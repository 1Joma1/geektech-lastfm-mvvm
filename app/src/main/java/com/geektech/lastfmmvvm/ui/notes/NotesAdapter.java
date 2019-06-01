package com.geektech.lastfmmvvm.ui.notes;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.geektech.lastfmmvvm.R;
import com.geektech.lastfmmvvm.entity.Note;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {

    private NotesViewModel mViewModel;
    private List<Note> NotesList;

    NotesAdapter(List<Note> NotesList) {
        this.NotesList = NotesList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_value_note, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(NotesList.get(i));
    }

    @Override
    public int getItemCount() {
        return NotesList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvDescription, mDate;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_history_note_title);
            tvDescription = itemView.findViewById(R.id.tv_history_note_description);
            mDate = itemView.findViewById(R.id.tv_history_note_date);
        }

        void bind(Note note) {
            tvTitle.setText(note.getTitle());
            tvDescription.setText(note.getDescription());
            mDate.setText(DateFormat.format("dd/MMM/yyyy\n hh:mm", note.getDate()).toString());

        }
    }
}
