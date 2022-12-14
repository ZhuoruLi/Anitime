package com.example.anitime.ui.slideshow;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anitime.Adapters.EventsRecyclerViewAdapter;
import com.example.anitime.Adapters.PetsRecyclerViewAdapter;
import com.example.anitime.EventActivity;
import com.example.anitime.R;
import com.example.anitime.RegisterUser;
import com.example.anitime.Repository.EventsRepo;
import com.example.anitime.Repository.PetsRepo;
import com.example.anitime.event_details;
import com.example.anitime.event_details3;
import com.example.anitime.event_details4;

public class SlideshowFragment extends Fragment implements EventsRecyclerViewAdapter.RecyclerviewOnClickListener {
    RecyclerView recyclerView;
    EventsRecyclerViewAdapter eventsRecyclerViewAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_events, container, false);
        recyclerView = rootView.findViewById(R.id.recyclerView);
        eventsRecyclerViewAdapter = new EventsRecyclerViewAdapter(EventsRepo.getEventsRepo().getEventModelList(), this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        recyclerView.setAdapter(eventsRecyclerViewAdapter);
        return rootView;
    }

    public void recyclerviewClick(int position) {
        Intent intent;
        System.out.println(position);
        if (position == 0) {
            intent = new Intent(getContext(), EventActivity.class);
        } else if (position == 1) {
            intent = new Intent(getContext(), event_details.class);
        } else if (position == 2) {
            intent = new Intent(getContext(), event_details3.class);
        } else {
            intent = new Intent(getContext(), event_details4.class);
        }

        startActivity(intent);

    }
}