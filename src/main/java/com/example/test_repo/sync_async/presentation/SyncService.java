package com.example.test_repo.sync_async.presentation;

import com.example.test_repo.common.entity.MemberEntity;
import com.example.test_repo.common.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SyncService {

    private final MemberRepository memberRepository;

    // call method가 synchronous 방식으로 동작하도록 변경
    public String call(final Long id) throws Exception {
        MemberEntity memberEntity = memberRepository.getById(id);
        return "hello " + memberEntity.getName();
    }

    public MemberEntity create() {
        return  memberRepository.create();
    }
}
