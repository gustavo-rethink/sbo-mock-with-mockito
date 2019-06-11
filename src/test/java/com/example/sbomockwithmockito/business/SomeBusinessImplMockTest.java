package com.example.sbomockwithmockito.business;

import com.example.sbomockwithmockito.data.SomeDataService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessImplMockTest {

    @InjectMocks
    SomeBusinessImpl someBusiness;

    @Mock
    SomeDataService mock;

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