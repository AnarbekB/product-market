package ru.balmukanov.productmarket.constant;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

import java.io.Serializable;

//todo delete
@AllArgsConstructor
public enum Type implements Serializable {

    @JsonProperty("card")
    CARD("card"),

    @JsonProperty("account")
    ACCOUNT("account"),

    @JsonProperty("deposit")
    DEPOSIT("deposit"),

    @JsonProperty("loan")
    LOAD("loan");

    private String value;
}
