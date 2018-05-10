package com.leogao.any.common.mockito;

public interface PersonDao {
    public Person fetchPerson(Integer personID);

    public void update(Person person);
}
