package io.fdlessard.codebites.httpclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Slf4j
@Service
public class CustomerGatewayImpl implements CustomerGateway {

    public Customer getCustomerById(long id) {

        log.debug("CustomerGatewayImpl.get({})", id);


        var httpClient = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(URI.create("http://localhost:8080/customers/" + id))
                .build();

        Customer customer;
        HttpResponse<String> response;
        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            customer = new ObjectMapper().readValue(response.body(), Customer.class);
        } catch (IOException io) {
            throw new RuntimeException(io.getMessage());
        } catch (InterruptedException ie) {
            throw new RuntimeException(ie.getMessage());

        }

        return customer;
    }

}


