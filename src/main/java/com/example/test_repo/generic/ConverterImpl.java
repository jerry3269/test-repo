package com.example.test_repo.generic;

import com.example.test_repo.common.domain.MemberDomain;
import com.example.test_repo.common.entity.MemberEntity;
import org.springframework.stereotype.Component;

@Component
public class ConverterImpl implements Converter<MemberDomain, MemberEntity> {

    private final MemberEntity memberEntity = new MemberEntity();

    public MemberDomain toMemberDomain() {
        return toDomain(memberEntity);
    }

    public MemberEntity toMemberEntity() {
        MemberDomain domain = toMemberDomain();
        return toEntity(domain);
    }
}
