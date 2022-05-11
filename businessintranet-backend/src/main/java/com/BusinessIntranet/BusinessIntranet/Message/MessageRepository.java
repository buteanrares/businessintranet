package com.BusinessIntranet.BusinessIntranet.Message;

import com.BusinessIntranet.BusinessIntranet.Employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message,Long> {
    Iterable<Message> findAllBySender(Employee sender);
    Iterable<Message> findAllByReceiver(Employee receiver);
    Iterable<Message> findAllByContentContains(String content);
}
