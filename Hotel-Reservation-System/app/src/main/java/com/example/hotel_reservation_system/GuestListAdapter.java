package com.example.hotel_reservation_system;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class GuestListAdapter extends RecyclerView.Adapter<GuestListAdapter.ViewHolder> {

    private List<GuestListData> guestListData;
    private LayoutInflater layoutInflater;

    GuestListAdapter(Context context, List<GuestListData> guestListData) {
        this.layoutInflater = LayoutInflater.from(context);
        this.guestListData = guestListData;
    }

    public GuestListAdapter(Context context) {
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @NotNull
    @Override
    public GuestListAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.guest_list_layout, parent, false);
        //return new GuestListAdapter.ViewHolder(view);
        GuestListAdapter.ViewHolder guestViewHolder = new GuestListAdapter.ViewHolder(view);
        int parentHeight= parent.getHeight();
        parent.getWidth();
        ViewGroup.LayoutParams layoutParams = guestViewHolder.itemView.getLayoutParams();
        layoutParams.height =  (parentHeight/ 3);//显示三条
        return guestViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView guestIdTextView,guestNameTextView,guestAgeTextView,guestGenderTextView;
        EditText guestNameEditText,guestAgeEditText;
        RadioGroup guestGenderRadioGroup;
        View guestSegmentView;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            guestIdTextView = itemView.findViewById(R.id.guest_id_text_view);
            guestNameTextView = itemView.findViewById(R.id.guest_name_text_view);
            guestAgeTextView = itemView.findViewById(R.id.guest_age_text_view);
            guestGenderTextView = itemView.findViewById(R.id.guest_gender_text_view);
            guestNameEditText = itemView.findViewById(R.id.guest_name_edit_text);
            guestAgeEditText = itemView.findViewById(R.id.guest_age_edit_text);
            guestGenderRadioGroup = itemView.findViewById(R.id.guest_genderradio_group);
            guestSegmentView = itemView.findViewById(R.id.guest_segment_view);
        }
    }
}
