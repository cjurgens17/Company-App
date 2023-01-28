package com.personPractice.repository;

import com.personPractice.models.Task;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TaskRepository extends CrudRepository<Task, Long> {

    @Modifying
    @Query(value = "UPDATE tasks SET title=?1, description=?2 WHERE id=?3", nativeQuery = true)
    int updateTask(String title, String description, Long id);

}
