package com.example.demo.service;

import java.util.List;

import com.example.demo.condition.UserCondition;
import com.example.demo.entity.UserDO;

public interface UserService {

    UserDO getUserById(Long userId);

    List<UserDO> listByCondition(UserCondition condition);

    // @CacheDeleteTransactional
    Long register(UserDO user);

    Long getUserIdByName(String name);

    UserDO doLogin(String name, String password);

    void updateUser(UserDO user);

    void deleteUserById(Long userId);

    List<UserDO> testMagic(String name, String password, Long... ids);

    List<UserDO> testMagic(String name, String password, List<Long> ids);


    void testDeleteMagicForArg(String name, String password, Long... ids);

    List<UserDO> testDeleteMagicForRetVal(String name, String password, Long... ids);

    List<UserDO> loadUsers();

    UserDO[] loadUsers(Long... ids);

    List<UserDO> deleteUsers();
}
