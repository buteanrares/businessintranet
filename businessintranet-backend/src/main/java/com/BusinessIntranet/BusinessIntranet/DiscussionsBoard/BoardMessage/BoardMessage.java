package com.BusinessIntranet.BusinessIntranet.DiscussionsBoard.BoardMessage;

import com.BusinessIntranet.BusinessIntranet.DiscussionsBoard.BoardTopic.BoardTopic;
import com.BusinessIntranet.BusinessIntranet.Employee.Employee;
import com.BusinessIntranet.BusinessIntranet.SharedModels.Message;

import javax.persistence.*;

@Entity(name="BoardMessages")
public class BoardMessage extends Message {

    public BoardMessage() {
    }

    public BoardMessage(Employee sender, String content) {
        super(sender, content);
    }
}
