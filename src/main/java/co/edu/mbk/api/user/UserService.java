package co.edu.mbk.api.user;

import co.edu.mbk.api.user.web.SaveUserDto;
import co.edu.mbk.api.user.web.UserDto;
import com.github.pagehelper.PageInfo;

public interface UserService {

   UserDto findById(Integer id);
  PageInfo<UserDto> findWithPaging(int pageNum, int pageSize);

   UserDto updateById(Integer id, SaveUserDto saveUserDto);
   UserDto create(SaveUserDto saveUserDto);
}
