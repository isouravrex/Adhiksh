package com.bandwidth.adhiksh.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bandwidth.adhiksh.Activities.AppointmentDetails;
import com.bandwidth.adhiksh.model.AppModel;
import com.bandwidth.adhiksh.R;

import java.util.List;

public class AppointmentAdapter extends RecyclerView.Adapter<AppointmentAdapter.ViewHolder> {

    private Context mContext;
    List<AppModel> list;

    public AppointmentAdapter(Context mContext, List<AppModel> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.card_appointment, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        AppModel demo = list.get(position);

        holder.subject.setText(demo.getSubject());
        holder.date.setText(demo.getDate());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView subject,date;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            date=itemView.findViewById(R.id.datetv);

            subject = itemView.findViewById(R.id.subjectTv);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, AppointmentDetails.class);

                    intent.putExtra("subject", list.get(getAdapterPosition()).getSubject());
                    intent.putExtra("appointmentId", list.get(getAdapterPosition()).getAppointmentId());
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
