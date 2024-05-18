package co.edu.mbk.api.user;

import co.edu.mbk.api.user.web.SaveUserDto;
import co.edu.mbk.api.user.web.UserDto;
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
    public UserDto findById(Integer id) {
        User user = userMapper.selectById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("User with id =%d is not found")));
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
