package code_for_good.linkage;

import java.util.List;

/**
 * Created by dimarammfire on 17.11.17.
 */

public class Request {

    private boolean urgency;
    private UserProfile receiver;
    private List<String> issues;
    private List<String> languages;
    private RefereeInfo info;

    public Request(boolean urgency, UserProfile receiver, List<String> issues,
                   List<String> languages, RefereeInfo info) {
        this.urgency = urgency;
        this.receiver = receiver;
        this.issues = issues;
        this.languages = languages;
        this.info = info;
    }


}
