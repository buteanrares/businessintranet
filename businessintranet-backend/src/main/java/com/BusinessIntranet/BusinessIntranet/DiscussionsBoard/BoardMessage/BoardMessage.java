package com.BusinessIntranet.BusinessIntranet.DiscussionsBoard.BoardMessage;

import com.BusinessIntranet.BusinessIntranet.Employee.Employee;
import com.BusinessIntranet.BusinessIntranet.Common.SharedModels.Message;

import javax.persistence.*;

@Entity
public class BoardMessage extends Message {

    public BoardMessage() {
    }

    public BoardMessage(Employee sender, String content) {
        super(sender, content);
    }
}
