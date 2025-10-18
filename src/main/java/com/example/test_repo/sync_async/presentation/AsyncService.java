package com.example.test_repo.sync_async.presentation;

import com.example.test_repo.common.entity.Member;
import com.example.test_repo.common.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@RequiredArgsConstructor
@Service
public class AsyncService {

    private final MemberRepository memberRepository;


    // call method가 asynchronous 방식으로 동작하도록 변경
    // @Async 어노테이션을 사용하여 비동기 처리

    @Async
    public CompletableFuture<String> call(final Long id) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Member member = memberRepository.getById(id);
                return "hello " + member.getName();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    public Member create() {
        return memberRepository.create();
    }
}
