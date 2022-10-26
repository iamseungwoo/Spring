package com.example.board.service;

import com.example.board.entity.Board;
import com.example.board.entity.Member;
import com.example.board.repository.Member.MemberRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Transactional
public class MemberService {

    MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long signInMember(Member member) {
        memberRepository.save(member);
        return member.getIdx();
    }

    public Member logInMember(String userId, String userPwd) {
        return memberRepository.findByUserId(userId)
                .filter(m -> m.getUserPwd().equals(userPwd))
                .orElse(null);
    }

    public Member findByIdx(Long userIdx) {
        return memberRepository.findByUserIdx(userIdx)
                .orElse(null);
    }

    public Member findByUserId(String userId) {
        return memberRepository.findByUserId(userId).orElse(null);
    }

    public List<Board> findUserPost() {

        return memberRepository.findUserPost();
    }
}
