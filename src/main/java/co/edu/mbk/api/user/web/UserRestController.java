package co.edu.mbk.api.user.web;

import co.edu.mbk.api.user.UserService;
import co.edu.mbk.base.BaseApi;
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
