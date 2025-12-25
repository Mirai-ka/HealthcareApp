package com.example.healthcare.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.healthcare.R;
import com.example.healthcare.models.ServiceItem;
import java.util.List;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder> {
    private final List<ServiceItem> serviceList;

    public ServiceAdapter(List<ServiceItem> serviceList) {
        this.serviceList = serviceList;
    }

    @NonNull
    @Override
    public ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_service, parent, false);
        return new ServiceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceViewHolder holder, int position) {
        if (serviceList == null || serviceList.isEmpty() || position < 0 || position >= serviceList.size()) {
            return;
        }

        ServiceItem item = serviceList.get(position);
        if (item == null) {
            return;
        }

        // Безопасная установка текста
        setTextSafe(holder.tvTitle, item.getTitle());
        setTextSafe(holder.tvSubtitle, item.getSubtitle());
    }

    private void setTextSafe(TextView textView, String text) {
        if (textView != null) {
            textView.setText(text != null ? text : "");
        }
    }

    @Override
    public int getItemCount() {
        return serviceList != null ? serviceList.size() : 0;
    }

    public static class ServiceViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvSubtitle;

        public ServiceViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvSubtitle = itemView.findViewById(R.id.tvSubtitle);
        }
    }
}