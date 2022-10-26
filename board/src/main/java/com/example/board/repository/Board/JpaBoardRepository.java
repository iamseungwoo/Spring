package com.example.board.repository.Board;

import com.example.board.entity.Board;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaBoardRepository implements BoardRepository {
    EntityManager em;

    public JpaBoardRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Board save(Board board) {
        em.persist(board);
        return board;
    }

    @Override
    public Optional<Board> findById(Long Id) {
        Board findBoard = em.find(Board.class, Id);
        return Optional.ofNullable(findBoard);
    }

    @Override
    public List<Board> findAll() {
        return em.createQuery("select b from Board b", Board.class)
                .getResultList();
    }
}
