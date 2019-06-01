package com.geektech.lastfmmvvm.ui.counter;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Pair;

import com.geektech.lastfmmvvm.App;
import com.geektech.lastfmmvvm.data.ActionsRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CounterViewModel extends ViewModel {

    LiveData<Integer> counter;
    MutableLiveData<List<Pair<String, Date>>> actionsHistory = new MutableLiveData<>();
    private ArrayList<Pair<String, Date>> history = new ArrayList<>();
    private ActionsRepository repository = App.actionsRepository;

    public CounterViewModel(){
        this.counter = repository.getCounter();
    }

    void addAction(String action) {
        history.add(new Pair<>(action, new Date()));
        actionsHistory.setValue(history);
    }

    void increment(){
        repository.increment();
        addAction("increment");
    }

    void decrement(){
        repository.decrement();
        addAction("decrement");
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
