package com.example.healthcare.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.healthcare.R;
import com.example.healthcare.models.Doctor;
import java.util.List;

public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.DoctorViewHolder> {
    private List<Doctor> doctorList;
    private OnDoctorClickListener listener;

    public DoctorAdapter(List<Doctor> doctorList, OnDoctorClickListener listener) {
        this.doctorList = doctorList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public DoctorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_doctor, parent, false);
        return new DoctorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorViewHolder holder, int position) {
        if (doctorList == null || doctorList.isEmpty() || position < 0 || position >= doctorList.size()) {
            return;
        }

        Doctor doctor = doctorList.get(position);
        if (doctor == null) {
            return;
        }

        // Безопасная установка текста
        setTextSafe(holder.textDoctorName, doctor.getName());
        setTextSafe(holder.textDoctorSpecialty, doctor.getSpecialty());
        setTextSafe(holder.textRating, doctor.getRating());
        setTextSafe(holder.textDistance, doctor.getDistance());

        // Обработчик клика
        if (listener != null) {
            holder.itemView.setOnClickListener(v -> listener.onDoctorClick(doctor));
        }
    }

    private void setTextSafe(TextView textView, String text) {
        if (textView != null) {
            textView.setText(text != null ? text : "");
        }
    }

    @Override
    public int getItemCount() {
        return doctorList != null ? doctorList.size() : 0;
    }

    public static class DoctorViewHolder extends RecyclerView.ViewHolder {
        TextView textDoctorName;
        TextView textDoctorSpecialty;
        TextView textRating;
        TextView textDistance;

        public DoctorViewHolder(@NonNull View itemView) {
            super(itemView);
            textDoctorName = itemView.findViewById(R.id.textDoctorName);
            textDoctorSpecialty = itemView.findViewById(R.id.textDoctorSpecialty);
            textRating = itemView.findViewById(R.id.textRating);
            textDistance = itemView.findViewById(R.id.textDistance);
        }
    }

    public interface OnDoctorClickListener {
        void onDoctorClick(Doctor doctor);
    }
}