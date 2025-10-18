package com.example.test_repo.common.repository;

import com.example.test_repo.common.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static java.lang.Thread.sleep;

@Slf4j
@Repository
public class MemberRepository {

    private final Map<Long, Member> members = new HashMap<>();

    public Member getById(final long id) throws Exception {
        log.info("waiting...1s");
        sleep(1000); // 1초 대기
        Optional<Member> member = Optional.ofNullable(members.get(id));
        if(member.isEmpty()){
            throw new RuntimeException("Member not found with id: " + id);
        }
        return member.get();
    }

    public Member create() {
        Member member = new Member();
        members.put(member.getId(), member);
        return member;
    }

    public Map<Long, Member> getMembers() {
        return Collections.unmodifiableMap(members);
    }
}
