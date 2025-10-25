package com.example.test_repo.common.repository;

import com.example.test_repo.aop.annotation.Logging;
import com.example.test_repo.common.entity.MemberEntity;
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

    private final Map<Long, MemberEntity> members = new HashMap<>();

    @Logging
    public MemberEntity getById(final long id) throws Exception {
        log.info("waiting...1s");
        sleep(1000); // 1초 대기
        Optional<MemberEntity> member = Optional.ofNullable(members.get(id));
        if(member.isEmpty()){
            throw new RuntimeException("Member not found with id: " + id);
        }
        return member.get();
    }

    public MemberEntity create() {
        MemberEntity memberEntity = new MemberEntity();
        members.put(memberEntity.getId(), memberEntity);
        return memberEntity;
    }

    public Map<Long, MemberEntity> getMembers() {
        return Collections.unmodifiableMap(members);
    }
}
