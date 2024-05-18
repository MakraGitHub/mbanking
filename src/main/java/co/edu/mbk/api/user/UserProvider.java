package co.edu.mbk.api.user;
import org.apache.ibatis.jdbc.SQL;

public class UserProvider {
    private final String USERS ="users";
    public String buildUpdateSql(){
        return new SQL(){{
            UPDATE(USERS);
            SET("name = #{u.name}");
            SET("gender = #{u.gender}");
            SET("is_student = #{u.isStudent}");
            SET("student_card_id = #{u.studentCardId}");
            WHERE("id = #{u.id}");
        }}.toString();
    }

    public String buildSelectByIdSql(){
        return new SQL() {{
            SELECT("*");
            FROM(USERS);
            WHERE("id = #{id}");
            AND();
            WHERE("is_deleted = FALSE");
        }}.toString();
    }

    public String buildInsertSql(){
        return new SQL() {{
            INSERT_INTO(USERS);
            VALUES("name", "#{u.name}");
            VALUES("gender", "#{u.gender}");
            VALUES("is_deleted", "FALSE");
            VALUES("is_student", "#{u.isStudent}");
            VALUES("student_card_id", "#{u.studentCardId}");
        }}.toString();
    }
}
