package com.geektech.lastfmmvvm.data;

import android.arch.lifecycle.MutableLiveData;

import java.util.ArrayList;

public class ActionsRepository {

    private MutableLiveData<Integer> counterLiveData = new MutableLiveData<>();
    private ArrayList<Integer> counts = new ArrayList<>();

    public MutableLiveData<Integer> getCounter() {
        counterLiveData.setValue(0);
        return counterLiveData;
    }

    public void increment() {
        if (counterLiveData.getValue() == null) return;
            counterLiveData.setValue(counterLiveData.getValue() + 1);
    }

    public void decrement() {
        if (counterLiveData.getValue() == null) return;
            counterLiveData.setValue(counterLiveData.getValue() - 1);
    }

    public Integer getCounter(int position) {
        return counts.get(position);
    }
}
