package org.mwatt.umapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class CreateUpdateUserInformationDto {
    @JsonIgnore
    private Long id;
    private String userName;
    private String firstName;
    private Optional<String> middleName;
    private String lastName;
    private String userType;
    private Optional<Date> birthday;

    protected CreateUpdateUserInformationDto() {}

    public static UserInformation convertToEntity(CreateUpdateUserInformationDto dto) {
        UserInformation userInformation = new UserInformation();
        userInformation.setId(dto.getId());
        userInformation.setUserName(dto.getUserName());
        userInformation.setFirstName(dto.getFirstName());

        userInformation.setMiddleName(dto.getMiddleName().orElse(null));

        userInformation.setLastName(dto.getLastName());
        userInformation.setUserType(dto.getUserType());

        userInformation.setBirthday(dto.getBirthday().orElse(null));

        return userInformation;
    }

    public static CreateUpdateUserInformationDto to(Long id, String userName, String firstName, Optional<String> middleName, String lastName, String userType, Optional<Date> birthday) {
        CreateUpdateUserInformationDto dto = new CreateUpdateUserInformationDto();
        dto.setId(id);
        dto.setUserName(userName);
        dto.setFirstName(firstName);
        dto.setMiddleName(middleName);
        dto.setLastName(lastName);
        dto.setUserType(userType);
        dto.setBirthday(birthday);
        return dto;
    }
}
