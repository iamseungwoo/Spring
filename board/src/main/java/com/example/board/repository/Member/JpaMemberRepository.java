package com.example.board.repository.Member;

import com.example.board.entity.Board;
import com.example.board.entity.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository {
    EntityManager em;

    @Override
    public List<Board> findUserPost() {
        System.out.println("error");
        return em.createQuery("select b from Board b join fetch b.username", Board.class)
                .getResultList();
    }

    @Override
    public Optional<Member> findByUserId(String userId) {
        Member query = em.createQuery("select m from Member m where m.userId = :userId", Member.class)
                .setParameter("userId", userId).getSingleResult();
        return Optional.ofNullable(query);

    }

    @Override
    public Optional<Member> findByUserIdx(Long userIdx) {
        Member member = em.find(Member.class, userIdx);
        return Optional.ofNullable(member);
    }

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }
}
