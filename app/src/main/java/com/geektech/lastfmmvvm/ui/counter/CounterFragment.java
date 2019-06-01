package com.geektech.lastfmmvvm.ui.counter;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.geektech.lastfmmvvm.R;

public class CounterFragment extends Fragment {

    private CounterViewModel mViewModel;
    private TextView tvCounter;
    private Button btnIncrement, btnDecrement;

    public static CounterFragment newInstance() {
        return new CounterFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.counter_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnIncrement = view.findViewById(R.id.counter_increment);
        btnDecrement = view.findViewById(R.id.counter_decrement);
        tvCounter = view.findViewById(R.id.counter);

        btnIncrement.setOnClickListener(v -> mViewModel.increment());
        btnDecrement.setOnClickListener(v -> mViewModel.decrement());
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getActivity() == null) return;

        mViewModel = ViewModelProviders.of(getActivity()).get(CounterViewModel.class);

        mViewModel.counter.observe(this, integer -> {
            if (integer != null) {
                tvCounter.setText(integer.toString());
            }
        });
    }

}
