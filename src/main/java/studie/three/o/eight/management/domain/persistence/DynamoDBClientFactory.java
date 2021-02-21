package studie.three.o.eight.management.domain.persistence;

import com.amazonaws.auth.AWSCredentialsProviderChain;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import io.micronaut.context.env.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PreDestroy;
import java.util.concurrent.atomic.AtomicReference;

@Factory
public class DynamoDBClientFactory {
    private static final Logger LOG = LoggerFactory.getLogger(DynamoDBClientFactory.class);

    AtomicReference<AmazonDynamoDB> amazonDynamoDBAtomicReference = new AtomicReference<>();

    @Bean
    AmazonDynamoDB dynamoDBClient(Environment environment) {
        String region = environment.getProperty("aws_region", String.class, Regions.EU_CENTRAL_1.getName());

        AWSCredentialsProviderChain awsCredentialsProviderChain = new DefaultAWSCredentialsProviderChain();

        AmazonDynamoDB amazonDynamoDB = AmazonDynamoDBClientBuilder.standard()
                .withCredentials(awsCredentialsProviderChain)
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", region))
                .build();
        amazonDynamoDBAtomicReference.set(amazonDynamoDB);
        return amazonDynamoDBAtomicReference.get();
    }

    @PreDestroy
    public void shutdownAmazonDynamoDB() {
        LOG.info("Destroying DynamoDB client before shutdown");
        amazonDynamoDBAtomicReference.get().shutdown();
    }

}
