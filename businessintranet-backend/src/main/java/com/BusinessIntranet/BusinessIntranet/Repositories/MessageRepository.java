package com.BusinessIntranet.BusinessIntranet.Repositories;

import antlr.debug.MessageAdapter;
import com.BusinessIntranet.BusinessIntranet.Models.Account;
import com.BusinessIntranet.BusinessIntranet.Models.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MessageRepository extends JpaRepository<Message,Long> {
    Iterable<Message> findAllBySender(Account sender);
    Iterable<Message> findAllByReceiver(Account receiver);
    Iterable<Message> findAllByContentContains(String content);
}
