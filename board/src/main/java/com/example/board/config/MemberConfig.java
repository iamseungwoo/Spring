package com.example.board.config;

import com.example.board.repository.Member.JpaMemberRepository;
import com.example.board.repository.Member.MemberRepository;
import com.example.board.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class MemberConfig {
    EntityManager em;

    @Autowired
    public MemberConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new JpaMemberRepository(em);
    }
}
