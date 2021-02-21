package studie.three.o.eight.management.domain.mapper;


import studie.three.o.eight.management.domain.Client;
import studie.three.o.eight.management.service.dto.ClientRequest;

import javax.inject.Singleton;


@Singleton
public class ClientMapper {
    public Client build(ClientRequest clientRequest) {
        Client client = new Client();
        client.setId(clientRequest.getId());
        client.setName(clientRequest.getName());
        client.setInterval(clientRequest.getInterval());
        client.setWithoutTimeslot(clientRequest.isWithoutTimeslot());
        client.setPassword(clientRequest.getPassword());
        client.setInfo(clientRequest.getInfo());
        client.setNatureSession(clientRequest.isNatureSession());
        client.setSiblingSession(clientRequest.isSiblingSession());
        client.setAvailableFrom(clientRequest.getAvailableFrom());
        client.setAvailableTo(clientRequest.getAvailableTo());
        client.setRevenues(clientRequest.getRevenues());
        return client;
    }

}
