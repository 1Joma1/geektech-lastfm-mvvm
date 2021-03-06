package com.geektech.lastfmmvvm.ui.notes;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.geektech.lastfmmvvm.R;
import com.geektech.lastfmmvvm.entity.Note;

import java.util.Date;

public class AddNoteFragment extends Fragment {

    private EditText noteTitle, noteddescription;

    private NotesViewModel mViewModel;

    public static AddNoteFragment newInstance() {
        return new AddNoteFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.add_note_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() == null) return;
        mViewModel = ViewModelProviders.of(getActivity()).get(NotesViewModel.class);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        noteTitle = view.findViewById(R.id.et_note_title);
        noteddescription = view.findViewById(R.id.et_note_description);
        Button btnSave = view.findViewById(R.id.btnSave);

        btnSave.setOnClickListener(v -> {
            String Title = noteTitle.getText().toString().trim();
            String Desc = noteddescription.getText().toString().trim();
            Note note = new Note(Title, Desc);
            mViewModel.save(note);
            noteTitle.setText("");
            noteddescription.setText("");
        });
    }
}
