package com.gizcompony.prototype.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import com.gizcompony.prototype.models_adapters.Assistant;
import com.gizcompony.prototype.models_adapters.Complaint;
import com.gizcompony.prototype.models_adapters.ComplaintsAdapter;
import com.gizcompony.prototype.models_adapters.GenericListener;
import com.gizcompony.prototype.R;
import com.gizcompony.prototype.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        getWindow().setStatusBarColor(getResources().getColor(R.color.main_color));
        setContentView(binding.getRoot());

        List<Complaint> complaints = Assistant.getComplaints() ;
        ComplaintsAdapter adapter = new ComplaintsAdapter(complaints, new GenericListener<Complaint>() {
            @Override
            public void sendData(Complaint complaint) {
                Intent intent = new Intent(getApplicationContext() , MapsActivity.class);
                intent.putExtra(MapsActivity.COMPLAINT_KEY , complaint);
                startActivity(intent);
            }
        });

        binding.recyclerComplaints.setAdapter(adapter);
        binding.recyclerComplaints.setHasFixedSize(true);
        binding.recyclerComplaints.setLayoutManager(new LinearLayoutManager(this));
    }
}