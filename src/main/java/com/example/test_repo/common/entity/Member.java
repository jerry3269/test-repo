package com.example.test_repo.common.entity;

import lombok.Getter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Getter
@ToString
@Component
public class Member {

    private Long id;
    private String name;
    private String email;
    private static AtomicLong sequence = new AtomicLong(0);

    public Member() {
        long newId = sequence.getAndAdd(1);
        this.id = newId;
        this.name = newId + " name";
        this.email = newId + "@email.com";
    }
}
