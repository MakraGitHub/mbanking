package co.edu.mbk.api.user;

import co.edu.mbk.api.user.web.SaveUserDto;
import co.edu.mbk.api.user.web.UserDto;

public interface UserService {
   UserDto create(SaveUserDto saveUserDto);
}
