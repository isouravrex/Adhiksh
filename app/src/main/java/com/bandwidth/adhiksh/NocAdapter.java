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

public class NocAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<AppModel> list;

    public NocAdapter(Context mContext, List<AppModel> list) {
        this.mContext = mContext;
        this.list = list;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView subject;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            subject = itemView.findViewById(R.id.dogi);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, NocDetails.class);
                    intent.putExtra("subject", list.get(getAdapterPosition()).getSubject());
                    mContext.startActivity(intent);
                }
            });

        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.card_noc, parent, false);
        return new NocAdapter.ViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        AppModel demo = list.get(position);

//        holder.subject.setText(demo.getSubject());
    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
