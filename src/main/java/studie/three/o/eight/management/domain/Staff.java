package studie.three.o.eight.management.domain;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

@DynamoDBDocument
public class Staff {
    @DynamoDBAttribute(attributeName = "Name")
    private String name;
    @DynamoDBAttribute(attributeName = "PhoneNumber")
    private String phoneNumber;
    @DynamoDBAttribute(attributeName = "Email")
    private String email;
    @DynamoDBAttribute(attributeName = "Supervisor")
    private boolean supervisor;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isSupervisor() {
        return supervisor;
    }

    public void setSupervisor(boolean supervisor) {
        this.supervisor = supervisor;
    }
}
