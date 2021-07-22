package com.example.hotel_reservation_system;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class GuestListAdapter extends RecyclerView.Adapter<GuestListAdapter.ViewHolder> {

    private List<Integer> guestNumber;
    private List<HotelData> hotelData;
    private LayoutInflater layoutInflater;
    Context context;
    View rootView;
    Button submitButton;


    ArrayList<GuestData> guestsListData = new ArrayList<>();
    ArrayList<String> guestsName = new ArrayList<String>();
    ArrayList<String> guestsAge = new ArrayList<String>();
    ArrayList<String> guestsGender = new ArrayList<String>();




    boolean isOnTextChanged = false;

    GuestListAdapter(Context context, List<HotelData> hotelData) {
        this.layoutInflater = LayoutInflater.from(context);
        //this.guestNumber = guestNumber;
        this.hotelData = hotelData;
    }

    @NonNull
    @Override
    public GuestListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.guest_list_layout, parent, false);

        context = parent.getContext();
        rootView = ((Activity) context).getWindow().getDecorView().findViewById(android.R.id.content);
        //submitButton = (Button)rootView.findViewById(R.id.guests_information_submit_button);
        submitButton = rootView.findViewById(R.id.guests_information_submit_button);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GuestListAdapter.ViewHolder holder, int position) {

        //int id = hotelData.get(position);
        int id = position;
        String guestPosition = String.valueOf(position+1);

        for(int i=0;i<hotelData.size();i++){
            guestsGender.add("0");
        }

        holder.guestIdTextView.setText("Guest"+guestPosition);
        holder.guestNameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                isOnTextChanged = true;

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (isOnTextChanged){
                    isOnTextChanged = false;

                    try{
                        for(int i =0; i<=id; i++){
                            if(i!=id){
                                guestsName.add("null");
                            }else{
                                guestsName.add("null");
                                guestsName.set(id,s.toString());
                            }
                        }
                        Log.d("guestsName",guestsName.toString());

                    }catch (Exception e){
                        for(int i=0; i<=id; i++){
                            Log.d("NamesRemoved"," : "+i);
                            if(i == id){
                                guestsName.set(id,"null");
                            }
                        }

                    }
                }

            }
        });

        holder.guestAgeEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                isOnTextChanged = true;

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (isOnTextChanged){
                    isOnTextChanged = false;

                    try{
                        for (int i=0; i<=id; i++){
                            if(i!=id){
                                guestsAge.add("0");
                            }else{
                                guestsAge.add("0");
                                guestsAge.set(id,s.toString());
                            }
                        }
                        Log.d("guestsAge",guestsAge.toString());

                    }catch (Exception e){

                    }
                }

            }
        });

        holder.guestGenderRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int selectId = group.getCheckedRadioButtonId();
                //selectId = (selectId % 3);
                try{
                    for(int i=0; i<=id; i++){
                        if(holder.unknownButton.getId() == checkedId){
                            guestsGender.set(id,"2");
                        }
                        else if(holder.femaleButton.getId() == checkedId){
                            guestsGender.set(id,"1");
                        }
                        else if(holder.maleButton.getId() == checkedId){
                            guestsGender.set(id,"0");
                        }
                    }
                    Log.d("guestsGender",guestsGender.toString());
                }catch(Exception e){

                }
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hotel_name = hotelData.get(0).getHotel_name();
                String checkin = hotelData.get(0).getCheckin();
                String checkout = hotelData.get(0).getCheckout();
                HotelData postHotelData = new HotelData(hotel_name,checkin,checkout);
                for(int i=0; i< hotelData.size();i++){
                    String guest_name = guestsName.get(i);
                    int age = Integer.valueOf(guestsAge.get(i));
                    int gender = Integer.valueOf(guestsGender.get(i));

                    GuestData guest = new GuestData(guest_name,age,gender);

                    postHotelData.addGuest(guest);

                }

                Log.d("guestsListData",postHotelData.toString());
//                Api.getClient().getConfirmation(postHotelData){
//                    Confirmation confirmation = response.body();
//                }

            }
        });

    }

    @Override
    public int getItemCount() {
        if (hotelData!= null) {
            return hotelData.size();
        } else {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView guestIdTextView,guestNameTextView,guestAgeTextView,guestGenderTextView;
        EditText guestNameEditText,guestAgeEditText;
        RadioGroup guestGenderRadioGroup;
        RadioButton femaleButton, maleButton, unknownButton;
        View guestSegmentView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            guestIdTextView = itemView.findViewById(R.id.guest_id_text_view);
            guestNameTextView = itemView.findViewById(R.id.guest_name_text_view);
            guestAgeTextView = itemView.findViewById(R.id.guest_age_text_view);
            guestGenderTextView = itemView.findViewById(R.id.guest_gender_text_view);
            guestNameEditText = itemView.findViewById(R.id.guest_name_edit_text);
            guestAgeEditText = itemView.findViewById(R.id.guest_age_edit_text);
            guestGenderRadioGroup = itemView.findViewById(R.id.guest_genderradio_group);
            femaleButton = itemView.findViewById(R.id.guest_gender_female_radio);
            maleButton = itemView.findViewById(R.id.guest_gender_male_radio);
            unknownButton = itemView.findViewById(R.id.guest_gender_unknown_radio);
            guestSegmentView = itemView.findViewById(R.id.guest_segment_view);
        }
    }
}
