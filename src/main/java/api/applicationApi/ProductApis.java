package main.java.api.applicationApi;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import main.java.api.NetworkClientV2;
import main.java.api.SpecBuilder;
import main.java.pojo.AddObject;
import main.java.utils.logUtility.LogToAllure;
import main.java.utils.logUtility.LogType;
import main.java.utils.logUtility.LoggerFactory;

import java.util.List;

public class ProductApis {
    @Step("Sending request to add an product")
    public static Response postAddObject(AddObject addObject) {
        try {
            return NetworkClientV2.sendPOST(SpecBuilder.getRequestSpec(), addObject);
        } catch (Exception e) {
            // Handle the error gracefully
            LoggerFactory.getLogger(LogType.ALLURE_REPORT).log("Failed to send request to add a product: " + e.getMessage());
            throw new RuntimeException("Something went wrong while making the request!!");
        }
    }

    @Step("Sending request to get the list of all product")
    public static Response getListOfAllObjects() {
        try {
            return NetworkClientV2.sendGet();
        } catch (Exception e) {
            // Handle the error gracefully
            LoggerFactory.getLogger(LogType.ALLURE_REPORT).log("Failed to send request to get list of all product: " + e.getMessage());
            throw new RuntimeException("Something went wrong while making the request!!");
        }
    }

    @Step("Sending request to get the list of all products by specific IDs")
    public static Response getListOfObjectByIds(List<Integer> ids) {
        try {
            return NetworkClientV2.sendGet("id", ids);
        } catch (Exception e) {
            // Handle the error gracefully
            LoggerFactory.getLogger(LogType.ALLURE_REPORT).log("Failed to send request to get list of product by IDs: " + e.getMessage());
            throw new RuntimeException("Something went wrong while making the request!!");
        }
    }

    @Step("Sending request to get product by its ID")
    public static Response getListOfObjectById(String id) {
        try {
            return NetworkClientV2.sendGet("/" + id);
        } catch (Exception e) {
            // Handle the error gracefully
            LoggerFactory.getLogger(LogType.ALLURE_REPORT).log("Failed to send request to get the product by ID: " + e.getMessage());
            throw new RuntimeException("Something went wrong while making the request!!");
        }
    }

    @Step("Sending request to delete a product with specific ID")
    public static Response deleteObjectById(String id) {
        try {
            return NetworkClientV2.sendDelete(id);
        } catch (Exception e) {
            // Handle the error gracefully
            LoggerFactory.getLogger(LogType.ALLURE_REPORT).log("Failed to send request to delete the product by ID: " + e.getMessage());
            throw new RuntimeException("Something went wrong while making the request!!");
        }
    }


}
