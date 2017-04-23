package tom.criminalintent;

import android.support.v4.app.Fragment;

import tom.criminalintent.fragment.CrimeFragment;


public class MainActivity extends SingleFragmentActivity{
    @Override
    protected Fragment createFragment() {
        return new CrimeFragment();
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_fragment);
//        FragmentManager fm = getSupportFragmentManager();
//        Fragment fragment = fm.findFragmentById(R.id.main_frame);
//        if(fragment==null)
//        {
//            fragment = new CrimeFragment();
//            fm.beginTransaction()
//                    .add(R.id.main_frame,fragment)
//                    .commit();
//        }
//
//    }
}
