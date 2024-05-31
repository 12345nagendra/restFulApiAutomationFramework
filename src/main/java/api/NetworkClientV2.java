package main.java.api;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;

import static io.restassured.RestAssured.given;
import static main.java.api.SpecBuilder.getRequestSpec;
import static main.java.api.SpecBuilder.getResponseSpec;


public class NetworkClientV2 {
    public static Response sendPOST(RequestSpecification requestSpecification, Object requestBody) {
        return given(requestSpecification)
                .body(requestBody)
                .when()
                .post()
                .then().spec(getResponseSpec())
                .extract().response();
    }

    public static Response sendGet() {
        return given(getRequestSpec())
                .when()
                .get()
                .then().spec(getResponseSpec())
                .extract().response();
    }

    public static Response sendGet(String queryParam, List<Integer> params) {
        return given(getRequestSpec())
                .queryParam(queryParam, params.toArray())
                .when()
                .get()
                .then().spec(getResponseSpec())
                .extract().response();
    }

    public static Response sendGet(String param) {
        return given(getRequestSpec())
                .when()
                .get(param)
                .then().spec(getResponseSpec())
                .extract().response();
    }

    public static Response sendUPDATE(Object requestBody, String path) {
        return given(getRequestSpec())
                .body(requestBody)
                .when()
                .put(path)
                .then().spec(getResponseSpec())
                .extract().response();
    }

    public static Response sendPATCH(Object requestBody, String path) {
        return given(getRequestSpec())
                .body(requestBody)
                .when()
                .patch(path)
                .then().spec(getResponseSpec())
                .extract().response();
    }

    public static Response sendDelete(String path) {
        return given(getRequestSpec())
                .when()
                .delete(path)
                .then().spec(getResponseSpec())
                .extract().response();
    }
}
