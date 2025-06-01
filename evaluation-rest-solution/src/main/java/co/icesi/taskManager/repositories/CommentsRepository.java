package co.icesi.taskManager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.icesi.taskManager.model.Comments;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Long> {

}
