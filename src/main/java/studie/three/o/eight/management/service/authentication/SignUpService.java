package studie.three.o.eight.management.service.authentication;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import studie.three.o.eight.management.domain.AdminUser;
import studie.three.o.eight.management.domain.persistence.dto.AdminUserDTO;
import studie.three.o.eight.management.domain.persistence.DynamoDBAdminUserPersistenceBuilder;

import javax.inject.Inject;

@Controller("/signup")
@Secured(SecurityRule.IS_ANONYMOUS)
public class SignUpService {
    private static final Logger LOG = LoggerFactory.getLogger(SignUpService.class);

    @Inject
    DynamoDBAdminUserPersistenceBuilder dynamoDBPersistenceBuilder;

    @Post
    public HttpResponse<?> registerUser(AdminUserDTO adminUserDTO) {
        AdminUser adminUser = dynamoDBPersistenceBuilder.findAdminUser(adminUserDTO.getUsername());
        if (adminUser == null) {
            String hashedPassword = BCrypt.hashpw(adminUserDTO.getPassword(), BCrypt.gensalt());
            AdminUser newUser = dynamoDBPersistenceBuilder.storeAdminUser(adminUserDTO.getUsername(), hashedPassword, adminUserDTO.getEmail());
            if (newUser != null) return HttpResponse.status(HttpStatus.CREATED);
        }
        return HttpResponse.status(HttpStatus.BAD_REQUEST);

    }
}
