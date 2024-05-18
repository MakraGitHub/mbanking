package co.edu.mbk.api.user;

import co.edu.mbk.api.user.web.SaveUserDto;
import co.edu.mbk.api.user.web.UserDto;

public interface UserService {

   UserDto findById(Integer id);

   UserDto updateById(Integer id, SaveUserDto saveUserDto);
   UserDto create(SaveUserDto saveUserDto);
}
