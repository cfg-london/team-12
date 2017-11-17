package code_for_good.linkage;

import java.util.Optional;

/**
 * Created by dimarammfire on 17.11.17.
 */

class UserProfile {

    private String type;
    private Optional<String> name;
    private Optional<String> phone;
    private Optional<String> email;
    private Optional<String> address;
    private Optional<String> workplace;

    public UserProfile(String type) {
        this.type = type;
//        name.ifPresent(x -> this.name = x.);
    }
}
