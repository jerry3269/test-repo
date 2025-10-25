package com.example.test_repo;

import com.example.test_repo.sync_async.presentation.AsyncService;
import com.example.test_repo.common.entity.MemberEntity;
import com.example.test_repo.common.repository.MemberRepository;
import com.example.test_repo.sync_async.presentation.SyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CompletableFuture;

@SpringBootTest
public class SyncAsyncTest {

    @Autowired
    private SyncService syncService;

    @Autowired
    private AsyncService asyncService;

    @Autowired
    private MemberRepository memberRepository;

    @org.junit.jupiter.api.Test
    void syncTest() throws Exception {
        MemberEntity memberEntity = syncService.create();
        String call = syncService.call(memberEntity.getId());
        System.out.println(memberRepository.getMembers());
        System.out.println(call);
    }

    @org.junit.jupiter.api.Test
    void asyncTest() throws Exception {
        MemberEntity memberEntity = asyncService.create();
        CompletableFuture<String> call = asyncService.call(memberEntity.getId());
        call.thenAccept(result -> System.out.println(result));
        System.out.println(memberRepository.getMembers());
        System.out.println("이 줄은 즉시 실행됨!");
    }
}
