package com.example.cardiacmonitor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    Context context;
    ArrayList<Record> list;

    public MyAdapter(Context context, ArrayList<Record> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View recordView = LayoutInflater.from(context).inflate(R.layout.record_item,parent,false);
        return new MyViewHolder(recordView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Record record = list.get(position);
        holder.record_date_text.setText(record.getDataMeasured());
        holder.record_time_text.setText(record.getTimeMeasured());
        holder.record_comment_text.setText(record.getComment());
        holder.record_heart_rate_text.setText(record.getHeartRate());
        holder.record_diastole_number.setText(record.getDiastolicPressure());
        holder.record_systole_number.setText(record.getSystolicPressure());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        View recordColorView;
        TextView record_date_text,record_time_text, record_systole_text,record_diastole_text,record_systole_number,
                record_diastole_number,record_comment_text,record_heart_rate_text;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            recordColorView = itemView.findViewById(R.id.record_color_view);
            record_date_text = itemView.findViewById(R.id.record_date_text);
            record_time_text = itemView.findViewById(R.id.record_time_text);
            record_systole_text = itemView.findViewById(R.id.record_systole_text);
            record_diastole_text = itemView.findViewById(R.id.record_diastole_text);
            record_systole_number = itemView.findViewById(R.id.record_systole_number);
            record_diastole_number = itemView.findViewById(R.id.record_diastole_number);
            record_comment_text = itemView.findViewById(R.id.record_comment_text);
            record_heart_rate_text = itemView.findViewById(R.id.record_heart_rate_text);
        }
    }
}
