package org.apache.mockito.practice.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ServiceClassTest {

    @Mock
    private DatabaseClass databaseClass;
    private ServiceClass serviceClass;
    @BeforeEach
    void setUp() {
        serviceClass = new ServiceClass(databaseClass);
    }

    @AfterEach
    void tearDown() {
        databaseClass = null;
        serviceClass = null;
    }

    @Test
    @DisplayName("Test DB availability")
    void query() {
        assertNotNull(databaseClass);
        when(databaseClass.isAvailable()).thenReturn(true);
        assertTrue(serviceClass.query("qeuryString"),"Database may not be available");
    }

    @Test
    @DisplayName("Testing Overloaded toString()")
    void ensureMockitoReturnConfiguredValue(){
        when(databaseClass.getUniqueId()).thenReturn(42);
        assertEquals("Unique ID :42",serviceClass.toString(),"May have different value");
    }

}