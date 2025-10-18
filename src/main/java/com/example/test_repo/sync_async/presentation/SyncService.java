package com.example.test_repo.sync_async.presentation;

import com.example.test_repo.common.entity.Member;
import com.example.test_repo.common.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SyncService {

    private final MemberRepository memberRepository;

    // call method가 synchronous 방식으로 동작하도록 변경
    public String call(final Long id) throws Exception {
        Member member = memberRepository.getById(id);
        return "hello " + member.getName();
    }

    public Member create() {
        return  memberRepository.create();
    }
}
