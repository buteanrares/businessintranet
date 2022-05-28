package com.BusinessIntranet.BusinessIntranet.DiscussionsBoard.BoardMessage;

import com.BusinessIntranet.BusinessIntranet.DiscussionsBoard.BoardTopic.BoardTopic;
import com.BusinessIntranet.BusinessIntranet.Employee.Employee;
import com.BusinessIntranet.BusinessIntranet.Common.SharedModels.Message;

import javax.persistence.*;

@Entity
public class BoardMessage extends Message {
    private Long referencedBoardTopicId;

    public BoardMessage() {
    }

    public BoardMessage(Employee sender, Long referencedBoardTopicId, String content) {
        super(sender, content);
        this.referencedBoardTopicId=referencedBoardTopicId;
    }

    public Long getReferencedBoardTopicId() {
        return referencedBoardTopicId;
    }

    public void setReferencedBoardTopicId(Long referencedBoardTopicId) {
        this.referencedBoardTopicId = referencedBoardTopicId;
    }
}
