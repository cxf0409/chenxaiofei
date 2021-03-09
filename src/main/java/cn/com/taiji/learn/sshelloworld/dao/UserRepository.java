package cn.com.taiji.learn.sshelloworld.dao;


import cn.com.taiji.learn.sshelloworld.domain.User;

public interface UserRepository {

    Iterable<User> findAll();

    User save(User user);

    User findUser(Long id);

    void deleteUser(Long id);

}
