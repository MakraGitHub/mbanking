package co.edu.mbk.api.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class User {
    private Integer id;
    private String name;
    private String gender;
    private String oneSignalId;
    private Boolean isDeleted;
    private Boolean isStudent;
    private String studentCardId;
}
