package com.udacity.jwdnd.Spring_Security_Basics.mapper;

import com.udacity.jwdnd.Spring_Security_Basics.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

//class to interact with its respective database table

@Mapper
public interface UserMapper {

    //method to get a user object from the database by searching by the user's username
    @Select("SELECT * FROM USERS WHERE username = #{username}")
    User getUser(String username);

    //method to insert a user into the database, returning the generated ID
    @Insert("INSERT INTO USERS (username, salt, password, firstname, lastname) VALUES(#{username}, #{salt}, #{password}, #{firstName}, #{lastName})")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    int insert(User user);
}
