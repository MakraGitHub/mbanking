package co.edu.mbk.api.accounttype;

import org.apache.ibatis.jdbc.SQL;

public class AccountTypeProvider {
    public String buildSelectSql(){
        return new SQL(){{
           SELECT("*");
           FROM("account_types");
        }}.toString();
    }
}
