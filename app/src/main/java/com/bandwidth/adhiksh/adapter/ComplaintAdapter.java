package com.bandwidth.adhiksh.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bandwidth.adhiksh.views.ComplaintDetails;
import com.bandwidth.adhiksh.model.Model;
import com.bandwidth.adhiksh.R;

import java.util.List;

public class ComplaintAdapter extends RecyclerView.Adapter<ComplaintAdapter.ViewHolder> {

    private Context mContext;
    private List<Model> list;


    public ComplaintAdapter(Context mContext, List<Model> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.card_complaint, parent, false);
        return new ComplaintAdapter.ViewHolder(view);      }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Model complaint = list.get(position);

        holder.subj.setText(complaint.getSubject());
        holder.locality.setText(complaint.getLocality());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView subj,locality;
        String id;




        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            subj = itemView.findViewById(R.id.subj);
            locality=itemView.findViewById(R.id.locality);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, ComplaintDetails.class);
                    intent.putExtra("Complaints", list.get(getAdapterPosition()).getSubject());
                    intent.putExtra("ComplaintId", list.get(getAdapterPosition()).getComplaintId());

                    mContext.startActivity(intent);
                }
            });

        }
    }

}