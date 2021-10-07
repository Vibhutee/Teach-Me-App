package com.teach.me.app.Service;

import com.teach.me.app.DTO.UserDTO;
import com.teach.me.app.Exception.UserNotFoundException;
import com.teach.me.app.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    /**
     *
     * @param user
     */
    public User insertUser(User user);

    /**
     *
     * @return
     */
    public List<User> getAllUsers();

    /**
     *
     * @param id
     * @return
     */
    public User getUserById(int id) throws UserNotFoundException;

    User getUserForLogin(UserDTO user);
}
