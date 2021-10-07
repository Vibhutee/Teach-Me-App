package com.teach.me.app.Repository;

import com.teach.me.app.Model.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResponseRepository extends JpaRepository<Response, Integer > {

    //TODO List of response by testId and userId
//    @Query(value= "SELECT * FROM response where test_id=?1 and user_id=?2", nativeQuery = true)
//    List<Response> getResponseByUserIdAndTestId(int testId, int userId);

    List<Response> getByUserUserIdAndTestTestId(int userId, int testId);

    Optional<Response> getByUserUserIdAndQuestionQuestionId(int userId, int testId);


}
