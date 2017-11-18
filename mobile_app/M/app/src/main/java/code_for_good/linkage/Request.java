package code_for_good.linkage;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Request implements Parcelable {

    private boolean urgent; // Is the request urgent?
    private UserProfile referrer; // Who is sending the referral?
    private List<String> issues = new ArrayList<>(); // The list of issues that are the reason for the referral.
    private Referee info; // The information provided on the referee.

    public Request(boolean urgent, UserProfile referrer, List<String> issues, Referee info) {
        this.urgent = urgent;
        this.referrer = referrer;
        this.issues = issues;
        this.info = info;
    }

    public void send() {
        // Stub. Send email to specified address.
    }

    public Request(Parcel in) {
        urgent = in.readByte() != 0;
        referrer = (UserProfile) in.readParcelable(UserProfile.class.getClassLoader());
        in.readStringList(issues);
        info = in.readParcelable(Referee.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (urgent ? 1 : 0));
        parcel.writeParcelable(referrer, i);
        parcel.writeStringList(issues);
        parcel.writeParcelable(info, i);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Request createFromParcel(Parcel in) {
            return new Request(in);
        }

        public Request[] newArray(int size) {
            return new Request[size];
        }
    };

}
