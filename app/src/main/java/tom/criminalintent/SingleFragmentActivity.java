package tom.criminalintent;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

/**
 * Created by Tom on 2017/4/20.
 */

public abstract class SingleFragmentActivity extends FragmentActivity{
    protected  abstract Fragment createFragment();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.main_frame);
        if(fragment == null)
        {
            fragment = createFragment();
            fm.beginTransaction()
                    .add(R.id.main_frame,fragment)
                    .commit();
        }
    }
}
