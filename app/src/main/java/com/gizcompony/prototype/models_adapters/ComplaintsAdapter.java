package com.gizcompony.prototype.models_adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gizcompony.prototype.R;
import com.gizcompony.prototype.databinding.CustomItemComplaintBinding;

import java.util.List;

public class ComplaintsAdapter extends RecyclerView.Adapter<ComplaintsAdapter.ComplaintHolder> {

    List<Complaint> data;
    GenericListener<Complaint> listener ;

    public ComplaintsAdapter(List<Complaint> data, GenericListener<Complaint> listener) {
        this.data = data;
        this.listener = listener;
    }

    public void setData(List<Complaint> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ComplaintsAdapter.ComplaintHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ComplaintHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item_complaint , parent , false));
    }

    @Override
    public void onBindViewHolder(@NonNull ComplaintsAdapter.ComplaintHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ComplaintHolder extends RecyclerView.ViewHolder {


        CustomItemComplaintBinding binding ;
        Complaint complaint ;
        public ComplaintHolder(@NonNull View itemView) {
            super(itemView);

            binding = CustomItemComplaintBinding.bind(itemView);
            binding.tvDetails.setTag(0);

            binding.tvDetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if ((int)view.getTag()==0){
                        binding.tvDetails.setTag(1);
                        binding.tvDetails.setText("التفاصيل : "+complaint.getDetails());
                    }
                    else if ((int)view.getTag()==1){
                        binding.tvDetails.setTag(0);
                        binding.tvDetails.setText("عرض التفاصيل");
                    }
                }
            });

            binding.btnLocation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.sendData(complaint);
                }
            });
        }

        public void bind(Complaint complaint){
            this.complaint = complaint ;

            binding.tvAddress.setText("العنوان : "+complaint.getAddress());
            binding.tvDate.setText("التاريخ : "+ Assistant.formatDate(complaint.getDate()));
            binding.tvTitle.setText("ملخص الشكوى : "+complaint.getTitle());
        }
    }
}
