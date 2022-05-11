package com.BusinessIntranet.BusinessIntranet.Repositories;

import com.BusinessIntranet.BusinessIntranet.Models.Employee;
import com.BusinessIntranet.BusinessIntranet.Models.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message,Long> {
    Iterable<Message> findAllBySender(Employee sender);
    Iterable<Message> findAllByReceiver(Employee receiver);
    Iterable<Message> findAllByContentContains(String content);
}
