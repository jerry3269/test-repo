package com.example.test_repo.common.domain;

import com.example.test_repo.common.entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class MemberDomain implements Domain {
    private long id;
    private String name;
    private String email;

    @Override
    public MemberEntity  toEntity() {
        return new MemberEntity(
                id, name, email
        );
    }

}
