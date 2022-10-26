package com.example.board.controller;

import com.example.board.entity.Board;

import com.example.board.entity.Member;
import com.example.board.service.BoardService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BoardController {

    BoardService boardService;


    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/post/new")
    public String newPostForm() {
        return "boardForm";
    }

    @PostMapping("/post/new")
    public String newPost(Board board, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Member sessionMember = (Member) session.getAttribute("member");
        board.setUsername(sessionMember);
        board.setAuthor(sessionMember.getUserName());
        boardService.saveNewPost(board);
        return "redirect:/";
    }

    @GetMapping("/board")
    public String boardList(Model model) {
        List<Board> boardList = boardService.allPost();
        model.addAttribute("boardList", boardList);
        return "board";
    }

    @GetMapping("/post/detail/{boardId}")
    public String postDetail(@PathVariable("boardId") Long boardId, Model model) {
        Board detailPost = boardService.postDetailById(boardId);
        model.addAttribute("post", detailPost);
        return "detailPost";
    }

}
