/**
 * 
 */
package com.teach.me.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teach.me.app.Model.User;

import java.util.Optional;

/**
 * @author Vibhutee Vala
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {


    Optional<User> findByEmail(String email);
}
