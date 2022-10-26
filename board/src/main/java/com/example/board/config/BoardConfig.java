package com.example.board.config;

import com.example.board.repository.Board.BoardRepository;
import com.example.board.repository.Board.JpaBoardRepository;
import com.example.board.service.BoardService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class BoardConfig {

    EntityManager em;

    public BoardConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public BoardService boardService() {
        return new BoardService(boardRepository());
    }

    @Bean
    public BoardRepository boardRepository() {
        return new JpaBoardRepository(em);
    }
}
