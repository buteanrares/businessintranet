package com.BusinessIntranet.BusinessIntranet.DiscussionsBoard.BoardTopic;

import com.BusinessIntranet.BusinessIntranet.DiscussionsBoard.BoardTopic.Exceptions.BoardTopicNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardTopicService {
    private final BoardTopicRepository boardTopicRepository;

    @Autowired
    public BoardTopicService(BoardTopicRepository boardTopicRepository) {
        this.boardTopicRepository = boardTopicRepository;
    }

    public BoardTopic createBoardTopic(BoardTopic boardTopic) {
        return boardTopicRepository.save(boardTopic);
    }

    public List<BoardTopic> findAllBoardTopics() {
        return boardTopicRepository.findAll();
    }

    public BoardTopic findBoardTopicById(Long id) {
        return boardTopicRepository.findById(id)
                .orElseThrow(() -> new BoardTopicNotFoundException("Board topic with id " + id + " does not exist."));
    }

    public BoardTopic updateBoardTopic(BoardTopic boardTopic) {
        return boardTopicRepository.save(boardTopic);
    }

    public void deleteBoardTopic(Long id) {
        boardTopicRepository.deleteById(id);
    }
}
