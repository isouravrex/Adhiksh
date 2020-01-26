package com.bandwidth.adhiksh;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AppointmentAdapter extends RecyclerView.Adapter<AppointmentAdapter.ViewHolder> {

    private Context mContext;
    List<RecyclerAppointment> list;

    public AppointmentAdapter(Context mContext, List<RecyclerAppointment> list) {
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

        RecyclerAppointment demo = list.get(position);

        holder.subject.setText(demo.getSubject());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView subject;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            subject = itemView.findViewById(R.id.subjectTv);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, AppointmentDetails.class);
                    intent.putExtra("subject", list.get(getAdapterPosition()).getSubject());
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
