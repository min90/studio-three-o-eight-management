package studie.three.o.eight.management.authentication;

import edu.umd.cs.findbugs.annotations.Nullable;
import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.*;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import org.mindrot.jbcrypt.BCrypt;
import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import studie.three.o.eight.management.domain.AdminUser;
import studie.three.o.eight.management.domain.persistence.dto.AdminUserDTO;
import studie.three.o.eight.management.domain.persistence.DynamoDBAdminUserPersistenceBuilder;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;

@Singleton
public class AuthenticationProviderAdminUser implements AuthenticationProvider {
    private static final Logger LOG = LoggerFactory.getLogger(AuthenticationProvider.class);

    @Inject
    private DynamoDBAdminUserPersistenceBuilder dynamoDBPersistenceBuilder;

    @Override
    public Publisher<AuthenticationResponse> authenticate(@Nullable HttpRequest<?> httpRequest,
                                                          AuthenticationRequest<?, ?> authenticationRequest) {
        AdminUserDTO adminUser = httpRequest.getBody(AdminUserDTO.class).orElse(null);
        AdminUser storedAdminUser = adminUser != null ? dynamoDBPersistenceBuilder.findAdminUser(adminUser.getUsername()) : null;

        return Flowable.create(emitter -> {
            boolean passwordEquals = BCrypt.checkpw(adminUser.getPassword(), storedAdminUser.getHashedPassword());
            if(storedAdminUser != null && passwordEquals && adminUser.getUsername().equals(storedAdminUser.getUsername())) {
                emitter.onNext(new AdminUserDetails((String) authenticationRequest.getIdentity(), new ArrayList<>(), adminUser.getEmail()));
                emitter.onComplete();
            } else {
                emitter.onError(new AuthenticationException(new AuthenticationFailed()));
            }
            new UsernamePasswordCredentials();
        }, BackpressureStrategy.ERROR);
    }
}
