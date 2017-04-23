package tom.criminalintent.bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Tom on 2017/4/20.
 */

public class Crime {
    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;
    private String date;

    public Crime() {
        mId = UUID.randomUUID();
        mDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("EE-MM-dd-yyyy");
        date = sdf.format(mDate);
    }

    public UUID getmId() {
        return mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public boolean ismSolved() {
        return mSolved;
    }

    public void setmSolved(boolean mSolved) {
        this.mSolved = mSolved;
    }

    public String getmDate() {
        return date;
    }

    public void setmDate(String date) {
        this.date = date;
    }
}
