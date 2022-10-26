package com.example.board.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "board")
public class Board {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "username")
    private Member username;

    @Column(name = "date")
    @DateTimeFormat(pattern = "YYYY-MM-DD hh:mm:ss")
    private Date date;

    @Column(name = "author")
    private String author;
}
