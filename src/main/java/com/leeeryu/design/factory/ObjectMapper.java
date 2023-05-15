package com.leeeryu.design.factory;

import com.leeeryu.generic.Box;
import org.codehaus.jackson.map.type.CollectionType;
import org.codehaus.jackson.type.JavaType;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;

public class ObjectMapper {

    public enum DefaultType {
        JAVA_LANG_OBJECT("java lnag object"),
        OBJECT_AND_NOW_CONCRETE("objcet");

        private String description;
        DefaultType(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
    public ObjectMapper() {
        _typeFactory = TypeFactory.defaultInstance();
    }

    private TypeFactory _typeFactory;

    public TypeFactory getTypeFactory() {
        return _typeFactory;
    }

    public ObjectMapper setTypeFactory(TypeFactory f) {
        _typeFactory = f;
        return this;
    }

    public static void main(String[] args) {
        Box<Integer> box = new Box<>();
        box.setData(1);

        final Field[] declaredFields = box.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            Type type = declaredField.getGenericType();
            System.out.println("TypeFactory is a type: " + type + ", " + declaredField.getName());
            if (type instanceof ParameterizedType) {
                System.out.println("TypeFactory is a parameterized type");
                System.out.println();
//                ParameterizedType parameterizedType = (ParameterizedType) type;
//                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            } else if (type instanceof WildcardType) {
                System.out.println("TypeFactory is a wildcard type");
            } else {
                System.out.println("TypeFactory is a type");
            }
        }
    }
}

/**
 * final class는 상속 받을 수 없다.
 * 다양한 입력이 주어졌을 때 구체적인 JavaType 인스턴스를 생성하는 데
 * 사용되는 클래스
 */
final class TypeFactory {
    private TypeFactory() {
    }

    /**
     * Final methods 는 final 지시어를 통해 메소드 오버라이드를 제한
     * @return
     */
    public static TypeFactory defaultInstance() {
        return new TypeFactory();
    }

    private JavaType _constructType(Class<?> rawType) {
        return null;
    }

    public CollectionType constructCollectionType(Class<? extends Collection> collectionClass,  JavaType elementType) {
        return CollectionType.construct(collectionClass, elementType);
    }
}
