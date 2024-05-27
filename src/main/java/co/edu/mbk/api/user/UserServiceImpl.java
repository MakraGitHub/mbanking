package co.edu.mbk.api.user;

import co.edu.mbk.api.user.web.SaveUserDto;
import co.edu.mbk.api.user.web.UserDto;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{

    private final UserMapper userMapper;
    private final UserMapstruct userMapstruct;

    @Override
    public UserDto deleteById(Integer id) {
        if(userMapper.existsById(id)){
            UserDto userDto = findById(id);
            userMapper.updateIsDeleted(id,true);
            return userDto;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("User with id =%d is not found id DB",id));
    }

    @Override
    public PageInfo<UserDto> findWithPaging(int pageNum, int pageSize) {
        //TODO: call method select in mybatis mapper
        PageInfo<User> userDtoPageInfo = PageHelper.startPage(pageNum,pageSize)
                .doSelectPageInfo(userMapper::select);
        return userMapstruct.userPageInfoToUserDtoPageInfo(userDtoPageInfo);
    }

    @Override
    public UserDto findById(Integer id) {
        User user = userMapper.selectById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("User with id =%d is not found",id)));
        return userMapstruct.userToUserDto(user);
    }

    @Override
    public UserDto updateById(Integer id, SaveUserDto saveUserDto) {
        if(userMapper.existsById(id)){
            //TODO : update user(Model)
            User user = userMapstruct.saveUserDtoToUser(saveUserDto);
            user.setId(id);
            userMapper.update(user);
            return findById(id);
        }
        //Throw your business exception
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
               String.format( "User with ID = %d is not found in DB",id));
    }

    @Override
    public UserDto create(SaveUserDto saveUserDto) {
        User user = userMapstruct.saveUserDtoToUser(saveUserDto);
        userMapper.insert(user);
         return findById(user.getId());
    }
}
