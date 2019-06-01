package com.geektech.lastfmmvvm.ui.notes;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geektech.lastfmmvvm.R;
import com.geektech.lastfmmvvm.entity.Note;

import java.util.ArrayList;
import java.util.List;

public class NotesFragment extends Fragment {

    private NotesViewModel mViewModel;
    private List<Note> notesRecycler = new ArrayList<>();
    private NotesAdapter adapter;
    private RecyclerView recyclerView;

    public static NotesFragment newInstance() {
        return new NotesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.notes_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() == null) return;
        mViewModel = ViewModelProviders.of(getActivity()).get(NotesViewModel.class);
        mViewModel.notes.observe(getActivity(), new Observer<List<Note>>() {
            @Override
            public void onChanged(@Nullable List<Note> notes) {
                if (notes != null) {
                    notesRecycler.clear();
                    notesRecycler.addAll(notes);
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.notes_recycler);
        adapter = new NotesAdapter(notesRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }
}
