package com.example.hotel_reservation_system;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HotelGuestDetailsFragment extends Fragment {

    View view;
    //String numberOfGuest = getArguments().getString("number of guests");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.hotel_guest_details_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView hotelRecapTextView = view.findViewById(R.id.hotel_recap_text_view);

        String hotelName = getArguments().getString("hotel name");
        String hotelPrice = getArguments().getString("hotel price");
        String hotelAvailability = getArguments().getString("hotel availability");
        String checkInDate = getArguments().getString("check in date");
        String checkOutDate = getArguments().getString("check out date");
        String numberOfGuest = getArguments().getString("number of guests");


        hotelRecapTextView.setText("You have selected " +hotelName+ ". The cost will be $ "+hotelPrice+ " and availability is " +hotelAvailability+". The number of Guests are "+numberOfGuest);

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i < Integer.valueOf(numberOfGuest); i++)
        {
            list.add(i);
        }

//        for(int i = 0; i < Integer.valueOf(numberOfGuest).intValue();i++){
//            guestListData.add(new GuestListData("test",25,1));
//        }

        // Set up the RecyclerView
        //ArrayList<HotelListData> hotelListData = initHotelListData();
        RecyclerView recyclerView = view.findViewById(R.id.guest_list_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        GuestListAdapter guestListAdapter = new GuestListAdapter(getActivity(),list);
        recyclerView.setAdapter(guestListAdapter);


    }

//    public ArrayList<Integer> initGuestListData() {
//        ArrayList<Integer> list = new ArrayList<>();
//
//        for(int i=0; i < Integer.valueOf(numberOfGuest); i++)
//        {
//            list.add(i);
//        }
//
//        return list;
//    }

    public ArrayList<GuestListData> initGuestListData2() {
        ArrayList<GuestListData> list = new ArrayList<>();

        list.add(new GuestListData("test",25,1));
        list.add(new GuestListData("test",25,1));
        list.add(new GuestListData("test",25,1));

        return list;
    }
}
