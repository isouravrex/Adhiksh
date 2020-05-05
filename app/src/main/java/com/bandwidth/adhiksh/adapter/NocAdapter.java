package com.bandwidth.adhiksh.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bandwidth.adhiksh.views.NocDetails;
import com.bandwidth.adhiksh.model.NocModel;
import com.bandwidth.adhiksh.R;

import java.util.List;

public class NocAdapter extends RecyclerView.Adapter<NocAdapter.ViewHolder> {

    private Context mContext;
    private List<NocModel> list;

    public NocAdapter(Context mContext, List<NocModel> list) {
        this.mContext = mContext;
        this.list = list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.card_noc, parent, false);
        return new NocAdapter.ViewHolder(view);    }

    @Override
    public  void onBindViewHolder(@NonNull NocAdapter.ViewHolder holder, int position) {
        NocModel noc = list.get(position);

        holder.subject.setText(noc.getSubject());
        holder.categorey.setText(noc.getCategory());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView subject,categorey;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            categorey = itemView.findViewById(R.id.categorytv);
            subject = itemView.findViewById(R.id.subject_tv);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, NocDetails.class);
                    intent.putExtra("subject", list.get(getAdapterPosition()).getSubject());
                    intent.putExtra("nocId", list.get(getAdapterPosition()).getNocId());
                    mContext.startActivity(intent);
                }
            });

        }
    }
}
