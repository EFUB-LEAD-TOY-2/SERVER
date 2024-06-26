package com.efub.leadtoyproject.domain.member.repository;

import com.efub.leadtoyproject.domain.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByMemberId(Long memberId);
    Optional<Member> findByEmail(String email);
}
