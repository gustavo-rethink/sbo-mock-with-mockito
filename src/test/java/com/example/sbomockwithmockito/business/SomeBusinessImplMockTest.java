package com.example.sbomockwithmockito.business;

import com.example.sbomockwithmockito.data.SomeDataService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SomeBusinessImplMockTest {

    SomeBusinessImpl someBusiness = new SomeBusinessImpl();
    SomeDataService mock = mock(SomeDataService.class);

    @Before
    public void init() {
        someBusiness.setSomeDataService(mock);
    }

    @Test
    public void calculateSumUsingDataService_usingMock() {
        when(mock.retrieveAllData()).thenReturn(new int[] {1, 2, 3});
        int result = someBusiness.calculateSumUsingDataService();
        int expectedResult = 6;
        assertEquals(expectedResult, result);
    }

    @Test
    public void calculateSumUsingDataServiceEmpty_usingMock() {
        when(mock.retrieveAllData()).thenReturn(new int[] {});
        someBusiness.setSomeDataService(mock);
        int result = someBusiness.calculateSumUsingDataService();
        int expectedResult = 0;
        assertEquals(expectedResult, result);
    }

}