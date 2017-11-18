package code_for_good.linkage;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class RequestBuilder implements Parcelable{

    private boolean urgent; // Is the request urgent?
    private UserProfile referrer; // Who is sending the referral?
    private List<String> issues; // The list of issues that are the reason for the referral.
    private Referee referee; // The information provided on the referee.

    public RequestBuilder() {
        this.issues = new ArrayList<>();
    }

    public RequestBuilder(Parcel in) {
        urgent = in.readByte() != 0;
        referrer = in.readParcelable(UserProfile.class.getClassLoader());
        in.readStringList(issues);
        referee = in.readParcelable(Referee.class.getClassLoader());

    }

    public static final Creator<RequestBuilder> CREATOR = new Creator<RequestBuilder>() {
        @Override
        public RequestBuilder createFromParcel(Parcel in) {
            return new RequestBuilder(in);
        }

        @Override
        public RequestBuilder[] newArray(int size) {
            return new RequestBuilder[size];
        }
    };

    public Request build() {
        return new Request(urgent, referrer, issues, referee);
    }

    public RequestBuilder setUrgency(boolean urgent) {
        this.urgent = urgent;
        return this;
    }

    public RequestBuilder setReferrer(UserProfile referrer) {
        this.referrer = referrer;
        return this;
    }

    public RequestBuilder toggleIssue(String issue) {
        if (issues.contains(issue)) {
            return removeIssue(issue);
        }
        return addIssue(issue);
    }

    public RequestBuilder addIssue(String issue) {
        issues.add(issue);
        return this;
    }

    public RequestBuilder removeIssue(String issue) {
        issues.remove(issue);
        return this;
    }

    public RequestBuilder setReferee(Referee referee) {
        this.referee = referee;
        return this;
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
        parcel.writeParcelable(referee, i);
    }
}
