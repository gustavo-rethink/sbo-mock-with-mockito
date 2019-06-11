package com.example.sbomockwithmockito.business;

import org.junit.Test;

import static org.junit.Assert.*;

public class SomeBusinessImplTest {

    @Test
    public void calculateSum() {
        SomeBusinessImpl someBusiness = new SomeBusinessImpl();
        int result = someBusiness.calculateSum(new int[]{1, 2, 3});
        int expectedResult = 6;
        assertEquals(expectedResult, result);
    }
}