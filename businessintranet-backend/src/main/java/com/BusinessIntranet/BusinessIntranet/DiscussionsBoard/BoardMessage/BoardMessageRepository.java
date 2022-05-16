package com.BusinessIntranet.BusinessIntranet.DiscussionsBoard.BoardMessage;

import com.BusinessIntranet.BusinessIntranet.Employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardMessageRepository extends JpaRepository<BoardMessage,Long> {
    Iterable<BoardMessage> findAllBySender(Employee sender);
}
