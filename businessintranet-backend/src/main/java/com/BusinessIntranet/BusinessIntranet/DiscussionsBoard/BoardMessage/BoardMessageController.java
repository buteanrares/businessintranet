package com.BusinessIntranet.BusinessIntranet.DiscussionsBoard.BoardMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/boardmessage")
public class BoardMessageController {
    private BoardMessageService boardMessageService;

    @Autowired
    public BoardMessageController(BoardMessageService boardMessageService) {
        this.boardMessageService = boardMessageService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<BoardMessage>> getBoardMessages(){
        List<BoardMessage> boardMessages = boardMessageService.findAllBoardMessages();
        return new ResponseEntity<>(boardMessages, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<BoardMessage> getBoardMessageById(@PathVariable("id") Long id){
        BoardMessage boardMessage = boardMessageService.findBoardMessageById(id);
        return new ResponseEntity<>(boardMessage,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<BoardMessage> createBoardMessage(@RequestBody BoardMessage boardMessage){
        BoardMessage newBoardMessage = boardMessageService.createBoardMessage(boardMessage);
        return new ResponseEntity<>(newBoardMessage, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<BoardMessage> updateBoardMessage(@RequestBody BoardMessage boardMessage){
        BoardMessage updateBoardMessage = boardMessageService.updateBoardMessage(boardMessage);
        return new ResponseEntity<>(updateBoardMessage,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBoardMessage(@PathVariable("id") Long id){
        boardMessageService.deleteBoardMessage(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
