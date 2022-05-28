package com.BusinessIntranet.BusinessIntranet.DiscussionsBoard.BoardTopic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/boardtopic")
public class BoardTopicController {
    private final BoardTopicService boardTopicService;

    @Autowired
    public BoardTopicController(BoardTopicService boardTopicService) {
        this.boardTopicService = boardTopicService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<BoardTopic>> getBoardTopics(){
        List<BoardTopic> boardTopics = boardTopicService.findAllBoardTopics();
        return new ResponseEntity<>(boardTopics, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<BoardTopic> getBoardTopicById(@PathVariable("id") Long id){
        BoardTopic boardTopic = boardTopicService.findBoardTopicById(id);
        return new ResponseEntity<>(boardTopic,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<BoardTopic> createBoardTopic(@RequestBody BoardTopic boardTopic){
        BoardTopic newBoardTopic = boardTopicService.createBoardTopic(boardTopic);
        return new ResponseEntity<>(newBoardTopic,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<BoardTopic> updateBoardTopic(@RequestBody BoardTopic boardTopic){
        BoardTopic updateBoardTopic = boardTopicService.updateBoardTopic(boardTopic);
        return new ResponseEntity<>(updateBoardTopic,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBoardTopic(@PathVariable("id") Long id){
        boardTopicService.deleteBoardTopic(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
