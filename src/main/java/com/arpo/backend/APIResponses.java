package com.arpo.backend;


import org.json.JSONObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class APIResponses {
    public static final String ELEMENT_NOT_FOUND = "Element not found.";

    public static final String BAD_REQUEST_BODY = "Please check the request body, element could not be added/updated.";

    public static final String ELEMENT_NOT_DELETED = "Element could not be deleted.";

    public static final String ELEMENT_ADDED = "Element Added";

    public static final String ELEMENT_DELETED = "Element Deleted." ;

    APIResponses(){

    }

}
