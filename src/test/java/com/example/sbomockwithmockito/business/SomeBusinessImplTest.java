package com.example.sbomockwithmockito.business;

import com.example.sbomockwithmockito.data.SomeDataService;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SomeBusinessImplTest {

    @Test
    public void calculateSum() {
        SomeBusinessImpl someBusiness = new SomeBusinessImpl();
        int result = someBusiness.calculateSum(new int[]{1, 2, 3});
        int expectedResult = 6;
        assertEquals(expectedResult, result);
    }

    @Test
    public void calculateSumUsingDataService_usingStub() {
        SomeBusinessImpl someBusiness = new SomeBusinessImpl();
        someBusiness.setSomeDataService(new SomeDataServiceStub());
        int result = someBusiness.calculateSumUsingDataService();
        int expectedResult = 6;
        assertEquals(expectedResult, result);
    }

    @Test
    public void calculateSumUsingDataService_usingMock() {
        SomeBusinessImpl someBusiness = new SomeBusinessImpl();
        SomeDataService mock = mock(SomeDataService.class);
        when(mock.retrieveAllData()).thenReturn(new int[] {1, 2, 3});
        someBusiness.setSomeDataService(mock);
        int result = someBusiness.calculateSumUsingDataService();
        int expectedResult = 6;
        assertEquals(expectedResult, result);
    }
}