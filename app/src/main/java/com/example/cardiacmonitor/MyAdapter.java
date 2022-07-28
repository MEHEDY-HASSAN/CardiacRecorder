package com.example.cardiacmonitor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * This is an Adapter class that will get all the records into the RecyclerView
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    Context context;
    ArrayList<Record> list;
    ArrayList<String> keys;


    /**
     * This is the parameterized constructor
     * @param context
     *      context value
     * @param list
     *      this is a list which will contain all the records
     * @param keys
     *      this is a list which will contain all the keys of the firebase basebase data
     */

    public MyAdapter(Context context, ArrayList<Record> list , ArrayList<String>keys) {
        this.context = context;
        this.list = list;
        this.keys = keys;
    }

    /**
     * This is the parameterized ViewHolder
     * @param parent
     *      contain all the viewGroup
     * @param viewType
     *      this will tell the type of the view
     */

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View recordView = LayoutInflater.from(context).inflate(R.layout.record_item,parent,false);
        return new MyViewHolder(recordView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Record record = list.get(position);
        holder.record_date_text.setText("Date : "+record.getDataMeasured());
        holder.record_time_text.setText("Time : "+record.getTimeMeasured());
        holder.record_comment_text.setText("Comment : "+record.getComment());
        holder.record_heart_rate_text.setText("Heart Rate : "+String.valueOf(record.getHeartRate()));
        holder.record_diastole_number.setText(String.valueOf(record.getDiastolicPressure()));
        holder.record_systole_number.setText(String.valueOf(record.getSystolicPressure()));

        if (record.getSystolicPressure()<=120 && record.getDiastolicPressure()<=80){
            holder.recordColorView.setBackgroundResource(R.color.green);
            holder.record_systole_text.setTextColor(Color.parseColor("#16D51E"));
            holder.record_diastole_text.setTextColor(Color.parseColor("#16D51E"));
            holder.record_diastole_number.setTextColor(Color.parseColor("#16D51E"));
            holder.record_systole_number.setTextColor(Color.parseColor("#16D51E"));
        }
        else if (record.getSystolicPressure()<=129 && record.getDiastolicPressure()<=80){
            holder.recordColorView.setBackgroundResource(R.color.yellow);
            holder.record_systole_text.setTextColor(Color.parseColor("#FFFF00"));
            holder.record_diastole_text.setTextColor(Color.parseColor("#FFFF00"));
            holder.record_diastole_number.setTextColor(Color.parseColor("#FFFF00"));
            holder.record_systole_number.setTextColor(Color.parseColor("#FFFF00"));
        }
        else if (record.getSystolicPressure()<=139 || record.getDiastolicPressure()<=89){
            holder.recordColorView.setBackgroundResource(R.color.orange);
            holder.record_systole_text.setTextColor(Color.parseColor("#FFA500"));
            holder.record_diastole_text.setTextColor(Color.parseColor("#FFA500"));
            holder.record_diastole_number.setTextColor(Color.parseColor("#FFA500"));
            holder.record_systole_number.setTextColor(Color.parseColor("#FFA500"));
        }
        else if (record.getSystolicPressure()<=180 && record.getDiastolicPressure()<=120){
            holder.recordColorView.setBackgroundResource(R.color.mid_red);
            holder.record_systole_text.setTextColor(Color.parseColor("#FB4D4D"));
            holder.record_diastole_text.setTextColor(Color.parseColor("#FB4D4D"));
            holder.record_diastole_number.setTextColor(Color.parseColor("#FB4D4D"));
            holder.record_systole_number.setTextColor(Color.parseColor("#FB4D4D"));
        }
        else{
            holder.recordColorView.setBackgroundResource(R.color.red);
            holder.record_systole_text.setTextColor(Color.parseColor("#FF0000"));
            holder.record_diastole_text.setTextColor(Color.parseColor("#FF0000"));
            holder.record_diastole_number.setTextColor(Color.parseColor("#FF0000"));
            holder.record_systole_number.setTextColor(Color.parseColor("#FF0000"));
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent UpdateIntent = new Intent(context,UpdateActivity.class);
                UpdateIntent.putExtra("key",keys.get(position));
                context.startActivity(UpdateIntent);
            }
        });
    }

    /**
     *  Get ItemCount
     * @return
     *   Return size of the list
     */

    @Override
    public int getItemCount() {
        return list.size();
    }


    /**
     * This is a viewHolder class with will contain all the view content of the cardview.
     */

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
