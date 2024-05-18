package co.edu.mbk.api.user;
import co.edu.mbk.api.user.web.SaveUserDto;
import co.edu.mbk.api.user.web.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
 public interface UserMapstruct {

    User saveUserDtoToUser(SaveUserDto dto);
    UserDto userToUserDto(User user);
}
