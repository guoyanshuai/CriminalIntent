package tom.criminalintent.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import tom.criminalintent.R;
import tom.criminalintent.bean.Crime;

/**
 * A simple {@link Fragment} subclass.
 */
public class CrimeFragment extends Fragment {
    private Crime crime;
    private EditText crime_title;
    private Button crime_date;
    private CheckBox checkBox;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        crime = new Crime();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_crime, container, false);
        crime_title = (EditText) v.findViewById(R.id.crime_title );
        crime_title.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                crime.setmTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        crime_date = (Button) v.findViewById(R.id.crime_date);
        crime_date.setText(crime.getmDate().toString());
        crime_date.setEnabled(false);
        checkBox = (CheckBox) v.findViewById(R.id.crime_solved);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                crime.setmSolved(isChecked);
            }
        });
        return v;
    }

}
