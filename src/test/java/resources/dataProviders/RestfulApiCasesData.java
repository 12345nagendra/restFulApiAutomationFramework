package test.java.resources.dataProviders;

import io.qameta.allure.Step;
import main.java.pojo.AddObject;
import main.java.pojo.Data;
import main.java.utils.CommonUtility;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;

public class RestfulApiCasesData {

    @DataProvider(name = "RequestPayloadsForAddObjects", parallel = true)
    public static Object[][] getRequestPayloads() {
        List<AddObject> testDataPayloads = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            testDataPayloads.add(addObjectRequestBuilder());
        }
        Object[][] testData = new Object[testDataPayloads.size()][1];
        for (int i = 0; i < testDataPayloads.size(); i++) {
            testData[i][0] = testDataPayloads.get(i);
        }
        return testData;
    }

    public static AddObject addObjectRequestBuilder() {
        Data data = Data.builder().year(CommonUtility.generateRandomYear(1900))
                .price(CommonUtility.generateRandomPrice(3000f, 100000f))
                .hardDiskSize(CommonUtility.generateRandomHardDiskSize())
                .cpuModel(CommonUtility.generateRandomCpuModels())
                .build();
        return AddObject.builder()
                .name(CommonUtility.generateRandomProductName())
                .data(data).build();
    }
}
