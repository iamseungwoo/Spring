package com.example.board.service;

import com.example.board.entity.Board;
import com.example.board.repository.Board.BoardRepository;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
public class BoardService {
    BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Board saveNewPost(Board board) {
        boardRepository.save(board);
        return board;
    }

    public List<Board> allPost() {
        return boardRepository.findAll();
    }

    public Board postDetailById(Long boardId) {
        return boardRepository.findById(boardId).orElseThrow();
    }
}
