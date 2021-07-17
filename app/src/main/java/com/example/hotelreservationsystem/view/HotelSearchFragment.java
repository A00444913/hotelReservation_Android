package com.example.hotelreservationsystem.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.hotelreservationsystem.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class HotelSearchFragment extends Fragment {

    View view;
    TextView welcomeTextView,checkSearchTextView;
    DatePicker checkInDatePicker,checkOutDatePicker;
    EditText guestsNumberEditText;
    Button checkButton,searchButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.hotel_search_layout,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        welcomeTextView = view.findViewById(R.id.welcome_text_view);
        checkInDatePicker = view.findViewById(R.id.checkin_date_picker);
        checkOutDatePicker = view.findViewById(R.id.checkout_date_picker);
        guestsNumberEditText = view.findViewById(R.id.guests_number_edit_text);
        checkButton = view.findViewById(R.id.check_button);
        searchButton = view.findViewById(R.id.search_button);
        checkSearchTextView = view.findViewById(R.id.check_search_text_view);

        //set Button
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String checkInDate = getDateFromCalendar(checkInDatePicker);
                String checkOutDate = getDateFromCalendar(checkOutDatePicker);
                String numberOfGuests = guestsNumberEditText.getText().toString();

                checkSearchTextView.setText("Your check in date is "+checkInDate+", and your check out date is "+checkOutDate+" and number of guests are "+numberOfGuests);

            }
        });
    }

    private String getDateFromCalendar(DatePicker datePicker){
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year,month,day);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = simpleDateFormat.format(calendar.getTime());
        return formattedDate;
    }
}
