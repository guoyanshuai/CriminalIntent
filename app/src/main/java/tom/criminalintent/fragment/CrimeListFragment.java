package tom.criminalintent.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.UUID;

import tom.criminalintent.CrimeLab;
import tom.criminalintent.CrimePagerActivity;
import tom.criminalintent.MainActivity;
import tom.criminalintent.R;
import tom.criminalintent.bean.Crime;

import static tom.criminalintent.R.id.list_item_title_date;

/**
 * A simple {@link Fragment} subclass.
 */
public class CrimeListFragment extends Fragment {

    private RecyclerView mCrimeRecyclerView;
    private CrimeAdapter adapter;
    private static final int REQUEST_CRIME = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crime_list, container, false);
        mCrimeRecyclerView = (RecyclerView) view.findViewById(R.id.crime_recycler_view);
        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        UpdateUI();
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        UpdateUI();
    }

    private class CrimeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTitleTextView;
        private TextView mTitleDate;
        private CheckBox mSolved_cb;
        private Crime crime;

        public CrimeHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            mTitleTextView = (TextView) itemView.findViewById(R.id.list_item_title);
            mTitleDate = (TextView) itemView.findViewById(list_item_title_date);
            mSolved_cb = (CheckBox) itemView.findViewById(R.id.solved_check_box);
        }

        public void bindcrime(Crime crime1) {
            crime = crime1;
            mTitleTextView.setText(crime.getmTitle());
            mTitleDate.setText(crime.getmDate());
            mSolved_cb.setChecked(crime.ismSolved());
        }

        @Override
        public void onClick(View v) {
            Intent intent = CrimePagerActivity.newIntent(getActivity(), crime.getmId());
            startActivityForResult(intent,REQUEST_CRIME);
        }
    }

    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder> {

        private List<Crime> mCrime;

        public CrimeAdapter(List<Crime> crime) {
            mCrime = crime;
        }

        @Override
        public CrimeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.crime_list_item, parent, false);
            return new CrimeHolder(view);
        }


        @Override
        public void onBindViewHolder(CrimeHolder holder, int position) {
            Crime crime = mCrime.get(position);
            holder.bindcrime(crime);
        }

        @Override
        public int getItemCount() {
            return mCrime.size();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==REQUEST_CRIME)
        {

        }
    }

    public void UpdateUI() {
        CrimeLab crimeLab = CrimeLab.get(getActivity());
        List<Crime> list = crimeLab.getCrime();
        if (adapter==null) {
            adapter = new CrimeAdapter(list);
            mCrimeRecyclerView.setAdapter(adapter);
        }
        else {
            adapter.notifyDataSetChanged();
        }
    }

}
