package com.capgemini.wsb.rest.exception;

public class EntityNotFoundException extends RuntimeException
{

    public EntityNotFoundException(Long id)
    {
        super("Could not find entity of id " + id);
    }

    public EntityNotFoundException(String messageArg)
    {
        super("Could not find entity by property value " + messageArg);
    }

    public EntityNotFoundException(int count) {
        super("Could not find entity with visit count more than " + count);
    }

    public EntityNotFoundException(double weight) {
        super("Could not find patients heavier than " + weight);
    }
}
