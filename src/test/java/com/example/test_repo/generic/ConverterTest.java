package com.example.test_repo.generic;

import com.example.test_repo.common.domain.MemberDomain;
import com.example.test_repo.common.entity.MemberEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConverterTest {

    @Autowired
    private ConverterImpl converter;

    @Test
    void toDomainTest() {
        MemberDomain domain = converter.toMemberDomain();
        System.out.println(domain);
    }

    @Test
    void toEntityTest() {
        MemberEntity entity = converter.toMemberEntity();
        System.out.println(entity);
    }

}