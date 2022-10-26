package com.example.board.repository.Board;

import com.example.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public interface BoardRepository{

    Board save(Board board);

    List<Board> findAll();

    Optional<Board> findById(Long Id);
}
