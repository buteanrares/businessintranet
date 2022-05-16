package com.BusinessIntranet.BusinessIntranet.DiscussionsBoard.BoardTopic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardTopicRepository extends JpaRepository<BoardTopic, Long> {
}
