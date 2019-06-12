package com.example.sbomockwithmockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ListMockTest {

    List mock;

    @Before
    public void setUp() throws Exception {
        mock = mock(List.class);
    }

    @Test
    public void argumentCapturing() {

        mock.add("Testing");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());

        assertEquals("Testing", captor.getValue());
    }
}
