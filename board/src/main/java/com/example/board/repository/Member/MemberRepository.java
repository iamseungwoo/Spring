package com.example.board.repository.Member;

import com.example.board.entity.Board;
import com.example.board.entity.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    public Member save(Member member);

    public Optional<Member> findByUserId(String userId);

    public Optional<Member> findByUserIdx(Long userIdx);

    public List<Board> findUserPost();
}
