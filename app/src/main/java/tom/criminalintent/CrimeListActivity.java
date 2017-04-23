package tom.criminalintent;

import android.support.v4.app.Fragment;

import tom.criminalintent.fragment.CrimeListFragment;

/**
 * Created by Tom on 2017/4/20.
 */

public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
