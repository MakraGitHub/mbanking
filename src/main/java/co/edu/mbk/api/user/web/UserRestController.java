package co.edu.mbk.api.user.web;

import co.edu.mbk.api.user.UserService;
import co.edu.mbk.base.BaseApi;
import com.github.pagehelper.PageInfo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/users")
@Slf4j
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    @DeleteMapping("/{id}")
    public BaseApi<?> delete(@PathVariable Integer id){
        UserDto userDto = userService.deleteById(id);
        return BaseApi.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("User has been deleted")
                .timestamp(LocalDateTime.now())
                .data(userDto)
                .build();
    }

    @GetMapping
    public BaseApi<?> findWithPaging(
            @RequestParam(required = false, defaultValue = "1")int pageNum,
            @RequestParam(required = false, defaultValue = "25")int pageSize){
        PageInfo<UserDto> userDtoPageInfo = userService.findWithPaging(pageNum, pageSize);

        return BaseApi.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("User have been found")
                .timestamp(LocalDateTime.now())
                .data(userDtoPageInfo)
                .build();
    }

    @GetMapping("/{id}")
    public BaseApi<?> findById(@PathVariable Integer id){
        UserDto userDto = userService.findById(id);
        return BaseApi.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("User has been found")
                .timestamp(LocalDateTime.now())
                .data(userDto)
                .build();
    }

    @PutMapping("/{id}")
    public BaseApi<?> updateById(@PathVariable Integer id,
                                 @Valid @RequestBody SaveUserDto saveUserDto){
        UserDto userDto = userService.updateById(id, saveUserDto);
        return BaseApi.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("User has been saved")
                .timestamp(LocalDateTime.now())
                .data(userDto)
                .build();

    }

    @PostMapping
    public BaseApi<?> create(@Valid @RequestBody SaveUserDto saveUserDto) {
        UserDto userDto = userService.create(saveUserDto);
        return BaseApi.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("User has been saved")
                .timestamp(LocalDateTime.now())
                .data(userDto)
                .build();
    }

}
