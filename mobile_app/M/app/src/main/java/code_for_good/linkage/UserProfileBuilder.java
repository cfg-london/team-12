package code_for_good.linkage;

/**
 * Created by dimarammfire on 17.11.17.
 */

public class UserProfileBuilder {

    private String type;
    private String name = "N/A";
    private String phone = "N/A";
    private String email = "N/A";
    private String address = "N/A";
    private String workplace = "N/A";

    private UserProfileBuilder(){}

    private UserProfileBuilder profileBuilder() {
        return new UserProfileBuilder();
    }

    public static UserProfileBuilder get() {
        return new UserProfileBuilder();
    }

    public UserProfile build() {
        return new UserProfile(type, name, phone, email, address, workplace);
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

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    @Override
    public String toString() {
        return "Name: " + name + " Telephone number:" + phone + " E-mail" + email
                + " Address" + address + " Workplace" + workplace;
    }
}
