package com.example.sbomockwithmockito.business;

import com.example.sbomockwithmockito.data.SomeDataService;

public class SomeDataServiceStub implements SomeDataService {
    @Override
    public int[] retrieveAllData() {
        return new int[]{1, 2, 3};
    }
}
