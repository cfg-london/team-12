package code_for_good.linkage;

/**
 * Created by dimarammfire on 17.11.17.
 */

public class UserProfileBuilder {

    private String type;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String workplace;

    private UserProfileBuilder(){}

    public static UserProfileBuilder profileBuilder() {
        return new UserProfileBuilder();
    }

    public UserProfile build() {
        return new UserProfile();
    }

    public UserProfileBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public UserProfileBuilder withPhone(String number) {
        this.phone = number;
        return this;
    }

    public UserProfileBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public UserProfileBuilder withAdress(String address) {
        this.address = address;
        return this;
    }

    public UserProfileBuilder withWorkplace(String workplace) {
        this.workplace = workplace;
        return this;
    }
}
