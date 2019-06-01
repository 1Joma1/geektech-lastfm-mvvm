package com.geektech.lastfmmvvm;

import android.app.Application;

import com.geektech.lastfmmvvm.data.ActionsRepository;
import com.geektech.lastfmmvvm.data.NotesRepository;

public class App extends Application {
    public static NotesRepository notesRepository;
    public static ActionsRepository actionsRepository;

    @Override
    public void onCreate() {
        super.onCreate();

        notesRepository = new NotesRepository();
        actionsRepository = new ActionsRepository();
    }
}
