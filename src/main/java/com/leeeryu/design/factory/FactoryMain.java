package com.leeeryu.design.factory;

import com.leeeryu.generic.Box;
import org.codehaus.jackson.map.type.SimpleType;
import org.codehaus.jackson.type.JavaType;

import java.util.List;

public class FactoryMain {

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        final TypeFactory typeFactory = objectMapper.getTypeFactory();

        final JavaType collectionType = typeFactory.constructCollectionType(List.class,
                SimpleType.construct(Box.class));

        System.out.println(collectionType);
    }
}
