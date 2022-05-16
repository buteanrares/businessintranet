package com.BusinessIntranet.BusinessIntranet.PrivateMessage;

import com.BusinessIntranet.BusinessIntranet.Employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivateMessageRepository extends JpaRepository<PrivateMessage,Long> {
    Iterable<PrivateMessage> findAllBySender(Employee sender);
    Iterable<PrivateMessage> findAllByReceiver(Employee receiver);
    Iterable<PrivateMessage> findAllByContentContains(String content);
}
