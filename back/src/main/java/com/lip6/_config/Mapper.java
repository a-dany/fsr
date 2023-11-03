package com.lip6._config;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/** Orika Mapper **/

public class Mapper {
    
    private static MapperFacade mapperFacade;
    static {
        mapperFacade = new DefaultMapperFactory.Builder().build().getMapperFacade();
    }
    public static <S, D> D map(S source, Class<D> destinationClass) {
        return mapperFacade.map(source, destinationClass);
    }

}
