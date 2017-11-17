package code_for_good.linkage;

import java.util.Set;

public class Request {

    private boolean urgent; // Is the request urgent?
    private UserProfile referrer; // Who is sending the referral?
    private Set<String> issues; // The list of issues that are the reason for the referral.
    private Referee info; // The information provided on the referee.

    public Request(boolean urgent, UserProfile referrer, Set<String> issues, Referee info) {
        this.urgent = urgent;
        this.referrer = referrer;
        this.issues = issues;
        this.info = info;
    }

    public void send() {
        // Stub. Send email to specified address.
    }

}
