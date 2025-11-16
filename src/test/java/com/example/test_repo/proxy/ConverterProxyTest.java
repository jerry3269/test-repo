package com.example.test_repo.proxy;

import com.example.test_repo.common.domain.MemberDomain;
import com.example.test_repo.common.entity.MemberEntity;
import com.example.test_repo.generic.Converter;
import org.junit.jupiter.api.Test;

class ConverterProxyTest {

    @Test
    void converterProxyTest(){
        Converter<MemberDomain, MemberEntity> memberConverter =
                ConverterProxy.create(MemberDomain.class, MemberEntity.class);

        MemberEntity memberEntity = new MemberEntity();
        MemberDomain domain = memberConverter.toDomain(memberEntity);
        System.out.println(domain);

        MemberEntity entity = memberConverter.toEntity(domain);
        System.out.println(entity);
    }
}