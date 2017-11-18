package code_for_good.linkage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RequestBuilder {

    private boolean urgent; // Is the request urgent?
    private UserProfile referrer; // Who is sending the referral?
    private List<String> issues = new ArrayList<>(); // The list of issues that are the reason for the referral.
    private Referee referree; // The information provided on the referee.

    private RequestBuilder() {}

    public Request build() {
        return new Request(urgent, referrer, issues, referree);
    }

    public RequestBuilder setUrgency(boolean urgent) {
        this.urgent = urgent;
        return this;
    }

    public RequestBuilder setReferrer(UserProfile referrer) {
        this.referrer = referrer;
        return this;
    }

    public RequestBuilder addIssue(String issue) {
        issues.add(issue);
        return this;
    }

    public RequestBuilder removeIssue(String issue) {
        issues.remove(issue);
        return this;
    }

    public RequestBuilder setReferree(Referee referree) {
        this.referree = referree;
        return this;
    }

}
