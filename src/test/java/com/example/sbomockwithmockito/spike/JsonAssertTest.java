package com.example.sbomockwithmockito.spike;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    String str = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";


    @Test
    public void jsonAssert() throws JSONException {
        String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
        JSONAssert.assertEquals(expectedResponse, str, true);
    }

    @Test
    public void jsonAssert_without_escape_char() throws JSONException {

        // Só é necessário ter escaped characters quando há espaços no valor do campo

        String expectedResponse = "{id:1,name:Ball,price:10,quantity:100}";
        JSONAssert.assertEquals(expectedResponse, str, true);
    }
}
