package com.fbs.central_api.service;

import com.fbs.central_api.connectors.DBApiConnector;
import com.fbs.central_api.enums.UserType;
import com.fbs.central_api.models.AppUser;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    DBApiConnector dbApiConnector;

    @Autowired
    public UserService(DBApiConnector dbApiConnector){
        this.dbApiConnector = dbApiConnector;
    }

    public List<AppUser> getSystemAdmins(){
        return dbApiConnector.callGetAllUserByUserType(UserType.SYSTEM_ADMIN.toString());
    }
}
