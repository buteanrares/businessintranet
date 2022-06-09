package com.BusinessIntranet.BusinessIntranet.DiscussionsBoard.BoardMessage;

import com.BusinessIntranet.BusinessIntranet.Employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardMessageRepository extends JpaRepository<BoardMessage,Long> {
    List<BoardMessage> findAllBySender(Employee sender);

    @Query(value = "select * from board_message where referenced_board_topic_id=?1 ", nativeQuery = true)
    List<BoardMessage> findAllByReferencedBoardTopicId(Long boardTopicId);
}
