/**
 * 
 */
package com.teach.me.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teach.me.app.Model.Test;

import java.util.List;

/**
 * @author Vibhutee Vala
 *
 */
@Repository
public interface TestRepository extends JpaRepository<Test, Integer> {

    public List<Test> getAllBySubject_SubjectId(int subjectId);

}
