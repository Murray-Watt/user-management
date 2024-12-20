package org.mwatt.umapi.sevices;

import org.mwatt.umapi.repository.UserInformation;
import org.mwatt.umapi.repository.UserInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInformationServiceImpl implements UserInformationService {

    @Autowired
    private UserInformationRepository clientRepository;

    @Override
    public UserInformation saveUser(UserInformation member) {
        return clientRepository.save(member);
    }

    @Override
    public List<UserInformation> getAllUsers() {
        return clientRepository.findAll();
    }
}
