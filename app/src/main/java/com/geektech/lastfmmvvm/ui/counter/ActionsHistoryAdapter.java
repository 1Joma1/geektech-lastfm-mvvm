package com.geektech.lastfmmvvm.ui.counter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.geektech.lastfmmvvm.R;

import java.util.Date;
import java.util.List;

public class ActionsHistoryAdapter extends RecyclerView.Adapter<ActionsHistoryAdapter.ViewHolder> {

    private CounterViewModel mViewModel;
    private List<Pair<String, Date>> counterHistoryList;

    ActionsHistoryAdapter(List<Pair<String, Date>> counterHistoryList) {
        this.counterHistoryList = counterHistoryList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_value_counter, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(counterHistoryList.get(i));
    }

    @Override
    public int getItemCount() {
        return counterHistoryList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvDate;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_history_counter);
            tvDate = itemView.findViewById(R.id.tv_history_date);

        }

        void bind(Pair<String, Date> counterHistory) {
            tvTitle.setText(counterHistory.first);
            tvDate.setText(DateFormat.format("dd/MMM/yyyy\n hh:mm", counterHistory.second).toString());
        }
    }
}
