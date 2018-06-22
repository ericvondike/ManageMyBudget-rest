package com.daklan.budget.control.rest.pojotest;

import com.daklan.budget.control.rest.dto.input.ShoppingCenterIn;
import com.daklan.budget.control.rest.pojotest.mainpojotestclasses.AbstractBeanTest;
import com.openpojo.reflection.impl.PojoClassFactory;
import org.junit.Test;

public class ShoppingCenterInTest extends AbstractBeanTest {

    @Test
    public void testPojoWithOpenpojo() {
        getOpenPojoValidator().validate(PojoClassFactory.getPojoClass(ShoppingCenterIn.class));
    }
}