package com.example.test_repo.common.entity;

import com.example.test_repo.common.domain.MemberDomain;
import lombok.Getter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Getter
@ToString
@Component
public class MemberEntity implements Entity {

    private Long id;
    private String name;
    private String email;
    private static AtomicLong sequence = new AtomicLong(0);

    public MemberEntity() {
        long newId = sequence.getAndAdd(1);
        this.id = newId;
        this.name = newId + " name";
        this.email = newId + "@email.com";
    }

    public MemberEntity(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @Override
    public MemberDomain toDomain() {
        return new MemberDomain(
                id, name, email
        );
    }
}
