package code_for_good.linkage;

import android.os.Parcel;
import android.os.Parcelable;

class UserProfile implements Parcelable {

    private String type;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String workplace;

    public UserProfile(String type, String name, String phone, String email, String address, String workplace) {
        this.type = type;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.workplace = workplace;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getWorkplace() {
        return workplace;
    }

    public UserProfile(Parcel in){

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
