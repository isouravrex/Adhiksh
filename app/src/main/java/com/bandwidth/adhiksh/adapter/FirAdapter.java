package com.bandwidth.adhiksh.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bandwidth.adhiksh.model.AppModel;
import com.bandwidth.adhiksh.views.FirDetails;
import com.bandwidth.adhiksh.R;

import java.util.List;

public class FirAdapter extends RecyclerView.Adapter<FirAdapter.FirViewHolder> {

    private Context mContext;
    private List<AppModel> list;

    public FirAdapter(Context mContext, List<AppModel> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public FirViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.card_home, parent, false);
        return new FirAdapter.FirViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull FirViewHolder holder, int position) {
        AppModel demo = list.get(position);

        holder.subject.setText(demo.getSubject());

    }

    @Override
    public int getItemCount() {
        return 7;
    }


    public class FirViewHolder extends RecyclerView.ViewHolder{

        TextView subject;

        public FirViewHolder(@NonNull View itemView) {
            super(itemView);
            subject=itemView.findViewById(R.id.dogi);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, FirDetails.class);
                    intent.putExtra("subject", list.get(getAdapterPosition()).getSubject());
                    mContext.startActivity(intent);
                }
            });

        }
    }
}
