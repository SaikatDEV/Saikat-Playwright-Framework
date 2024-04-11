package com.qa.project.tests;

import java.util.HashMap;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.Playwright;
import com.qa.project.utilities.AppConstants;

public class SampleApiTest {

    Playwright playwright;
    APIRequestContext apiReqContext;

    @Test(description = "Sample API", priority = 1)
    public void sampleApi(){
        playwright = Playwright.create();
        
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        
        apiReqContext = playwright.request().newContext(new APIRequest.NewContextOptions()
                        .setBaseURL("http://locahost:8888")
                        .setExtraHTTPHeaders(headers));
                        
        int resCode = apiReqContext.get("/comments").status();
        Assert.assertEquals(200, resCode);
    }
}
