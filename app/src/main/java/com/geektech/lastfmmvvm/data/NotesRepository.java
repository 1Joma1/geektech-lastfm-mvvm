package com.geektech.lastfmmvvm.data;

import android.arch.lifecycle.MutableLiveData;

import com.geektech.lastfmmvvm.entity.Note;

import java.util.ArrayList;
import java.util.List;

public class NotesRepository {

    private MutableLiveData<List<Note>> notesLiveData = new MutableLiveData<>();
    private ArrayList<Note> notes = new ArrayList<>();

    public MutableLiveData<List<Note>> getNotes() {
        return notesLiveData;
    }

    public void addNote(Note note) {
        notes.add(note);
        notesLiveData.setValue(notes);
    }

    public Note getNote(int position) {
        return notes.get(position);
    }
}
