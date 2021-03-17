package org.apache.mockito.practice.service;

import org.apache.mockito.practice.dao.IDAOService;

public class LoginManangementServiceImpl implements ILoginManagementService {
    private IDAOService idaoService;
    public LoginManangementServiceImpl(IDAOService idaoService){
        this.idaoService = idaoService;
    }
    @Override
    public boolean login(String username, String password) {
        if(username.equals("") || password.equals(""))
            throw new IllegalArgumentException("Empty Credentials");
        int count = idaoService.authenticate("username","password");
        if(count == 1)
            return true;
        else
            return false;
    }
}
