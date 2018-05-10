
/**
 * 类package-info.java的实现描述：TODO 类实现描述 
 * @author leogao 2018年4月19日 下午2:15:01
 */
package com.leogao.any.common.mockito;

public class Person {
    private final Integer personID;
    private final String  personName;

    public Person(Integer personID, String personName) {
        this.personID = personID;
        this.personName = personName;
    }

    public Integer getPersonID() {
        return personID;
    }

    public String getPersonName() {
        return personName;
    }
}
