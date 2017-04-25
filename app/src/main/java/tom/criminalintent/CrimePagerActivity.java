package tom.criminalintent;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;
import java.util.UUID;

import tom.criminalintent.bean.Crime;
import tom.criminalintent.fragment.CrimeFragment;

public class CrimePagerActivity extends FragmentActivity {

    private static final String EXTRA_CRIME_ID = "com.bignerdranch.android.criminalintent.crime_id";
    private ViewPager vp;
    private List<Crime> mCrime;

    public static Intent newIntent(Context packageContext, UUID crimeId) {
        Intent intent = new Intent(packageContext, CrimePagerActivity.class);
        intent.putExtra(EXTRA_CRIME_ID, crimeId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime_pager);
        vp = (ViewPager) findViewById(R.id.activity_crime_pager);
        mCrime = CrimeLab.get(this).getCrime();
        UUID crimeId = (UUID) getIntent().getSerializableExtra(EXTRA_CRIME_ID);
        FragmentManager fm = getSupportFragmentManager();
        vp.setAdapter(new FragmentPagerAdapter(fm) {
            @Override
            public Fragment getItem(int position) {
                Crime crime = mCrime.get(position);
                return CrimeFragment.newInstance(crime.getmId());
            }

            @Override
            public int getCount() {
                return mCrime.size();
            }
        });
        for (int i = 0; i < mCrime.size(); i++) {
            if (mCrime.get(i).getmId().equals(crimeId)) {
                vp.setCurrentItem(i);
                break;
            }
        }
    }
}
