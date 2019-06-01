package com.geektech.lastfmmvvm.ui.counter;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geektech.lastfmmvvm.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CounterHistoryFragment extends Fragment {

    private CounterViewModel mViewModel;
    private List<Pair<String, Date>> historyList = new ArrayList<>();
    private ActionsHistoryAdapter adapter;
    private RecyclerView recyclerView;

    public static CounterHistoryFragment newInstance() {
        return new CounterHistoryFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.history_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() == null) return;

        mViewModel = ViewModelProviders.of(getActivity()).get(CounterViewModel.class);

        mViewModel.actionsHistory.observe(this, pairs -> {
            historyList.clear();
            if (pairs != null) historyList.addAll(pairs);
            adapter.notifyDataSetChanged();
        });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.history_recyclerview);
        adapter = new ActionsHistoryAdapter(historyList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }
}
