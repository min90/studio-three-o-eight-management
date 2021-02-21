package studie.three.o.eight.management.domain;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

@DynamoDBDocument
public class Revenue {

    @DynamoDBAttribute(attributeName = "FiscalYear")
    public int fiscalYear;
    @DynamoDBAttribute(attributeName = "Revenue")
    public int revenue;

    public int getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(int fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }
}
