package code_for_good.linkage;

import java.util.Optional;

/**
 * Created by dimarammfire on 17.11.17.
 */

class UserProfile {

    private String type;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String workplace;

    public UserProfile(String type, String name, String phone,
                       String email, String address, String workplace) {
        this.type = type;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.workplace = workplace;
    }

    @Override
    public String toString() {
        return "Name: " + name + " Telephone number:" + phone + " E-mail" + email
                + " Address" + address + " Workplace" + workplace;
    }
}
