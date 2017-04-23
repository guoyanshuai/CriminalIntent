package tom.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import tom.criminalintent.bean.Crime;

/**
 * Created by Tom on 2017/4/20.
 */

public class CrimeLab {
    private static CrimeLab crimeLab;
    private List<Crime> mCrime;

    public static CrimeLab get(Context context) {
        if (crimeLab == null) {
            crimeLab = new CrimeLab(context);
        }
        return crimeLab;
    }

    private CrimeLab(Context context) {
        mCrime = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Crime crime = new Crime();
            crime.setmTitle("Crime # "+i);
            crime.setmSolved(i%2==0);
            mCrime.add(crime);

        }
    }

    public List<Crime> getCrime() {
        return mCrime;
    }

    public Crime getCrime(UUID id) {
        for (Crime crime : mCrime) {
            if (crime.getmId().equals(id))
                return crime;
        }
        return null;
    }
}
