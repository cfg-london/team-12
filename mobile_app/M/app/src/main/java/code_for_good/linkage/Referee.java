package code_for_good.linkage;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Referee implements Parcelable {

    private String name;
    private String address;
    private String gender;
    private String phoneNumber;
    private Integer age;
    private List<String> languages = new ArrayList<>();

    public Referee(String name, String address, String gender,
                   String phoneNumber, Integer age, List<String> languages) {
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.languages = languages;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public Referee(Parcel in) {
        name = in.readString();
        address = in.readString();
        gender = in.readString();
        phoneNumber = in.readString();
        in.readStringList(languages);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(address);
        parcel.writeString(gender);
        parcel.writeString(phoneNumber);
        parcel.writeStringList(languages);
    }

    public static final Creator<Referee> CREATOR = new Creator<Referee>() {
        @Override
        public Referee createFromParcel(Parcel in) {
            return new Referee(in);
        }

        @Override
        public Referee[] newArray(int size) {
            return new Referee[size];
        }
    };
}
