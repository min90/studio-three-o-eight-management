package studie.three.o.eight.management.domain;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "three-o-eight-management-user")
public class AdminUser {

    @DynamoDBHashKey
    private String username;
    @DynamoDBRangeKey
    private String hashedPassword;
    private String email;

    public AdminUser(){}

    public AdminUser(String username, String hashedPassword, String email) {
        this.username = username;
        this.hashedPassword = hashedPassword;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
