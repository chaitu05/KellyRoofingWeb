package com.vavv.web.repository;

import com.vavv.web.model.OrderTemp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderTempRepository extends JpaRepository<OrderTemp, String> {
    /*List<User> findByUsernameEquals(String username);
    User findFirstByUsernameEquals(String username);
    List<User> findTop5ByUsernameEquals(String username);
    List<User> findDistinctUserByUsernameEquals(String username);
    @Query(value = "select * from User user where BINARY user.username = :username and BINARY user.password = :password", nativeQuery = true)
    List<User> queryByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
    List<User> getUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
    User findFirstByGuid(String guid);*/

    @Override
    OrderTemp saveAndFlush(OrderTemp o);
}
