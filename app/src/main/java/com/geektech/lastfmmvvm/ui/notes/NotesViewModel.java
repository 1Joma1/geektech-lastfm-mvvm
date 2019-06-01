package com.geektech.lastfmmvvm.ui.notes;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.geektech.lastfmmvvm.App;
import com.geektech.lastfmmvvm.data.NotesRepository;
import com.geektech.lastfmmvvm.entity.Note;

import java.util.List;

public class NotesViewModel extends ViewModel {

    LiveData<List<Note>> notes;
    private NotesRepository repository = App.notesRepository;

    public NotesViewModel(){
        this.notes = repository.getNotes();
    }

    void save(Note note){
        repository.addNote(note);
    }

}
