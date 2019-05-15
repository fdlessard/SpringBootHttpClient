package io.fdlessard.codebites.httpclient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
public class Customer implements Serializable {

    private Long id;
    private String lastName;
    private String firstName;
    private String company;
    private Long addressId;
    private Long productId;
}
