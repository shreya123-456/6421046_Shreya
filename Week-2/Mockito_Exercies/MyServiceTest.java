package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

public class MyServiceTest {

    @Test
    public void testExternalAPI() {
        // Step 1: Mock the external API
        ExternalApi mockApi = mock(ExternalAPI.class);

        // Step 2: Stub the method
        when(mockApi.getData()).thenReturn("Mock Data");

        // Step 3: Inject mock into service
        MyService service = new MyService(mockApi);

        // Step 4: Call method and assert
        String result = service.fetchData();
        assertEquals("Mock Data", result);
    }
}


