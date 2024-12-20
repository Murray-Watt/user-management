package org.mwatt.umapi.api;

import org.mwatt.umapi.dto.CreateUpdateUserInformationDto;
import org.mwatt.umapi.dto.UserInformationDto;
import org.mwatt.umapi.repository.UserInformation;
import org.mwatt.umapi.sevices.UserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserInformationRestService {
    @Autowired
    private UserInformationService userInformationService;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/add")
    public UserInformationDto add(@RequestBody CreateUpdateUserInformationDto userDto){
        UserInformation user = CreateUpdateUserInformationDto.convertToEntity(userDto);
        UserInformation savedUser = userInformationService.saveUser(user);
        kafkaTemplate.send("mwatt-topic","{entity:\"userInformation\",\"savedUser\"}");
        return UserInformationDto.from(savedUser);

    }

    @GetMapping("/getAll")
    public List<UserInformationDto> list(){
        List<UserInformation> userList = userInformationService.getAllUsers();
        return userList.stream()
                .map(UserInformationDto::from)
                .collect(Collectors.toList());
    }
}
