package com.example.test_repo.proxy;

import com.example.test_repo.common.domain.Domain;
import com.example.test_repo.common.entity.Entity;
import com.example.test_repo.generic.Converter;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Converter 인터페이스의 프록시 구현체를 동적으로 생성하는 클래스
 */
public class ConverterProxy {

    @SuppressWarnings("unchecked")
    public static <D extends Domain, E extends Entity> Converter<D, E> create(
            Class<D> domainClass, Class<E> entityClass
    ) {
        return (Converter<D, E>) Proxy.newProxyInstance(
                Converter.class.getClassLoader(),
                new Class[]{Converter.class},
                new ConverterInvocationHandler<>(domainClass, entityClass)
        );
    }

    private static class ConverterInvocationHandler<D extends Domain, E extends Entity>
            implements InvocationHandler {

        private final Class<D> domainClass;
        private final Class<E> entityClass;

        ConverterInvocationHandler(Class<D> domainClass, Class<E> entityClass) {
            this.domainClass = domainClass;
            this.entityClass = entityClass;
        }

        @SuppressWarnings("unchecked")
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            String name = method.getName();

            System.out.println("🌀 [Proxy] Invoke: " + name);

            if (name.equals("toDomain")) {
                E entity = (E) args[0];
                Domain domain = entity.toDomain();
                return domainClass.cast(domain);
            } else if (name.equals("toEntity")) {
                D domain = (D) args[0];
                Entity entity = domain.toEntity();
                return entityClass.cast(entity);
            }

            // default 메서드 호출 처리 (equals, hashCode 등)
            if (method.isDefault()) {
                final Constructor<MethodHandles.Lookup> constructor =
                        MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, int.class);
                constructor.setAccessible(true);
                return constructor
                        .newInstance(method.getDeclaringClass(),
                                MethodHandles.Lookup.PRIVATE | MethodHandles.Lookup.PROTECTED
                                        | MethodHandles.Lookup.PACKAGE | MethodHandles.Lookup.PUBLIC)
                        .unreflectSpecial(method, method.getDeclaringClass())
                        .bindTo(proxy)
                        .invokeWithArguments(args);
            }

            throw new UnsupportedOperationException("Method not handled: " + name);
        }
    }
}
