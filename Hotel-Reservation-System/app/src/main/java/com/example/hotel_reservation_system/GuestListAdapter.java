package com.example.hotel_reservation_system;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class GuestListAdapter extends RecyclerView.Adapter<GuestListAdapter.ViewHolder> {

    private List<Integer> guestNumber;
    private LayoutInflater layoutInflater;

    GuestListAdapter(Context context, List<Integer> guestNumber) {
        this.layoutInflater = LayoutInflater.from(context);
        this.guestNumber = guestNumber;
    }

    @NonNull
    @Override
    public GuestListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.guest_list_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GuestListAdapter.ViewHolder holder, int position) {
        String guestPosition = String.valueOf(guestNumber.get(position)+1);

        holder.guestIdTextView.setText("Guest"+guestPosition);

    }

    @Override
    public int getItemCount() {
        if (guestNumber != null) {
            return guestNumber.size();
        } else {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView guestIdTextView,guestNameTextView,guestAgeTextView,guestGenderTextView;
        EditText guestNameEditText,guestAgeEditText;
        RadioGroup guestGenderRadioGroup;
        //RadioButton femaleButton, maleButton, unknownButton;
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
            //femaleButton = itemView.findViewById(R.id.guest_gender_female_radio);
            //maleButton = itemView.findViewById(R.id.guest_gender_male_radio);
            //unknownButton = itemView.findViewById(R.id.guest_gender_unknown_radio);
            guestSegmentView = itemView.findViewById(R.id.guest_segment_view);
        }
    }
}
