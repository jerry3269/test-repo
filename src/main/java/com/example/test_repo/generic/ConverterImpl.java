package com.example.test_repo.generic;

import com.example.test_repo.common.domain.MemberDomain;
import com.example.test_repo.common.entity.MemberEntity;
import org.springframework.stereotype.Component;

@Component
public class ConverterImpl implements Converter<MemberDomain, MemberEntity> {

    public MemberDomain toDomain() {
        MemberEntity memberEntity = new MemberEntity();
        return toDomain(memberEntity);
    }

    public MemberEntity toEntity() {
        MemberDomain domain = toDomain();
        return domain.toEntity();
    }
}
