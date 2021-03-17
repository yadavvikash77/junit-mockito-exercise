package org.apache.mockito.practice.service;

import org.apache.mockito.practice.dao.IDAOService;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Testing Login Service")
class LoginManangementServiceImplTest {
    private static IDAOService idaoService;
    private static LoginManangementServiceImpl loginManangementService;

    @BeforeAll
    public static void setUp() {
        idaoService = Mockito.mock(IDAOService.class);//Mocking Dao Class since there is no any implementation
        System.out.println("*** "+idaoService.getClass()+" *** "+ Arrays.toString(idaoService.getClass().getInterfaces()));
        loginManangementService = new LoginManangementServiceImpl(idaoService);
    }

    @AfterAll
    public static void tearDown() {
        idaoService = null;
        loginManangementService = null;
    }

    @Test
    @DisplayName("Testing with valid credentials")
    void testWithValidCredentials() {
        //Create Stub object for IDaoService
        Mockito.when(idaoService.authenticate("username","password")).thenReturn(1);
        assertTrue(loginManangementService.login("username","password"),"Credentials May not match");
    }

    @Test
    @DisplayName("Testing with invalid credentials")
    void testWithInvalidCredentials(){
        //Crete Stub Object with IDaoService
        Mockito.when(idaoService.authenticate("username1","password")).thenReturn(0);
        assertFalse(loginManangementService.login("username1","password"),"Credentials may match");
    }
    @Test
    @DisplayName("Testing with no credentials")
    void testWithNoCredentials(){
        assertThrows(IllegalArgumentException.class, ()->{
            loginManangementService.login("","");
        });
    }
}