package studie.three.o.eight.management.authentication;

import io.micronaut.security.authentication.UserDetails;

import java.util.Collection;

public class AdminUserDetails extends UserDetails {
    private String email;

    public AdminUserDetails(String username, Collection<String> roles) {
        super(username, roles);
    }

    public AdminUserDetails(String username, Collection<String> roles, String email) {
        super(username, roles);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
