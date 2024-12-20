package org.mwatt.umapi.sevices;

import org.mwatt.umapi.repository.UserInformation;

import java.util.List;

public interface UserInformationService {
    public UserInformation saveUser(UserInformation member);
    public List<UserInformation> getAllUsers();
}
