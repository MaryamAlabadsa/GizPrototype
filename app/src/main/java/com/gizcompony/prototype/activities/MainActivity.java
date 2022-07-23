package com.gizcompony.prototype.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.gizcompony.prototype.models_adapters.Assistant;
import com.gizcompony.prototype.models_adapters.Complaint;
import com.gizcompony.prototype.models_adapters.ComplaintsAdapter;
import com.gizcompony.prototype.models_adapters.GenericListener;
import com.gizcompony.prototype.R;
import com.gizcompony.prototype.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding ;

    FirebaseFirestore firestore ;
    ComplaintsAdapter adapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        getWindow().setStatusBarColor(getResources().getColor(R.color.main_color));
        setContentView(binding.getRoot());

        firestore = FirebaseFirestore.getInstance();

        List<Complaint> complaints = new ArrayList<>();
         adapter = new ComplaintsAdapter(complaints, new GenericListener<Complaint>() {
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

        getComplaints();

        binding.btnReload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getComplaints();
            }
        });
    }

    private void getComplaints(){
        firestore.collection("municipality").get().addOnSuccessListener(queryDocumentSnapshots -> {
            List<Complaint> complaints = queryDocumentSnapshots.toObjects(Complaint.class);
            adapter.setData(complaints);
        }).addOnFailureListener(e -> {

        });
    }
}