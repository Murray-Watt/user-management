package org.mwatt.umapi.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.mwatt.umapi.repository.UserInformation;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Optional;

@Getter
@Setter
@ToString
public class UserInformationDto {
    private Long id;
    private String userName;
    private String firstName;
    private Optional<String> middleName;
    private String lastName;
    private String userType;
    private Optional<Date> birthday;
    private ZonedDateTime createdDateTime;
    private ZonedDateTime modifiedDateTime;

    protected UserInformationDto() {}

    public static UserInformationDto from(UserInformation userInformation) {
        UserInformationDto userInformationDto = new UserInformationDto();
        userInformationDto.setId(userInformation.getId());
        userInformationDto.setUserName(userInformation.getUserName());

        // Handling Optional middleName
        if (userInformation.getMiddleName() != null) {
            userInformationDto.setMiddleName(Optional.of(userInformation.getMiddleName()));
        } else {
            userInformationDto.setMiddleName(Optional.empty());
        }

        userInformationDto.setLastName(userInformation.getLastName());
        userInformationDto.setUserType(userInformation.getUserType());

        if (userInformation.getBirthday() != null) {
            userInformationDto.setBirthday(Optional.of(userInformation.getBirthday()));
        } else {
            userInformationDto.setBirthday(Optional.empty());
        }

        userInformationDto.setCreatedDateTime(userInformation.getCreated());
        userInformationDto.setModifiedDateTime(userInformation.getLastModified());

        return userInformationDto;
    }
}
