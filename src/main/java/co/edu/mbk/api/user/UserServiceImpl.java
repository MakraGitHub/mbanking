package co.edu.mbk.api.user;

import co.edu.mbk.api.user.web.SaveUserDto;
import co.edu.mbk.api.user.web.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{

    private final UserMapper userMapper;
    private final UserMapstruct userMapstruct;
    @Override
    public UserDto create(SaveUserDto saveUserDto) {
        User user = userMapstruct.saveUserDtoToUser(saveUserDto);
        userMapper.insert(user);
        user = userMapper.selectById(user.getId()).orElseThrow(()->
                new RuntimeException("User is not found"));
        return userMapstruct.userToUserDto(user);
    }
}
