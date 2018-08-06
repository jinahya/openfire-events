package com.github.jinahya.openfire;

public interface OpenfireEventIdentifier<E extends Enum<E> & OpenfireEventIdentifier<E>> extends EventIdentifier<E> {

}
