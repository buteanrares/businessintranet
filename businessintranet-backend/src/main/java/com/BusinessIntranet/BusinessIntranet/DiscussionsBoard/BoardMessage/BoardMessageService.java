package com.BusinessIntranet.BusinessIntranet.DiscussionsBoard.BoardMessage;

import com.BusinessIntranet.BusinessIntranet.DiscussionsBoard.BoardMessage.Exceptions.BoardMessageNotFoundException;
import com.BusinessIntranet.BusinessIntranet.Employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardMessageService {
    public final BoardMessageRepository boardMessageRepository;

    @Autowired
    public BoardMessageService(BoardMessageRepository boardMessageRepository) {
        this.boardMessageRepository = boardMessageRepository;
    }

    public BoardMessage createBoardMessage(BoardMessage boardMessage) {
        return boardMessageRepository.save(boardMessage);
    }

    public List<BoardMessage> findAllBoardMessages() {
        return boardMessageRepository.findAll();
    }

    public BoardMessage findBoardMessageById(Long id) {
        return boardMessageRepository.findById(id)
                .orElseThrow(() -> new BoardMessageNotFoundException("Board message with id " + id + " does not exist"));
    }

    public List<BoardMessage> findAllBoardMessagesBySender(Employee sender) {
        return boardMessageRepository.findAllBySender(sender);
    }

    public BoardMessage updateBoardMessage(BoardMessage boardMessage) {
        return boardMessageRepository.save(boardMessage);
    }

    public void deleteBoardMessage(Long id) {
        boardMessageRepository.deleteById(id);
    }

    public List<BoardMessage> findAllByReferencedBoardTopicId(Long boardTopicId) {
        return boardMessageRepository.findAllByReferencedBoardTopicId(boardTopicId);
    }
}
