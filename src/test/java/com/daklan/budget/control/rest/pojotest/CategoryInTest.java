package com.daklan.budget.control.rest.pojotest;

import com.daklan.budget.control.rest.dto.input.CategoryIn;
import com.daklan.budget.control.rest.pojotest.mainpojotestclasses.AbstractBeanTest;
import com.openpojo.reflection.impl.PojoClassFactory;
import org.junit.Test;

public class CategoryInTest extends AbstractBeanTest {

    @Test
    public void testPojoWithOpenpojo() {
        getOpenPojoValidator().validate(PojoClassFactory.getPojoClass(CategoryIn.class));
    }
}
