package com.example.board.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "useridx")
    private Long idx;

    @Column(unique = true, name = "userid")
    private String userId;

    @Column(name = "pwd")
    private String userPwd;

    public void setIdx(Long idx) {
        this.idx = idx;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "username")
    private String userName;

    public List<Board> getBoardList() {
        return boardList;
    }

    @OneToMany
    @JoinColumn(name = "username")
    private List<Board> boardList = new ArrayList<Board>();

    public Long getIdx() {

        return idx;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public String getUserName() {
        return userName;
    }
}
