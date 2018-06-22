package com.daklan.budget.control.rest.pojotest;

import com.daklan.budget.control.rest.dto.output.ShoppingCenterOut;
import com.daklan.budget.control.rest.pojotest.mainpojotestclasses.AbstractBeanTest;
import com.openpojo.reflection.impl.PojoClassFactory;
import org.junit.Test;

public class ShoppingCenterOutTest extends AbstractBeanTest {

    @Test
    public void testPojoWithOpenPojo() {
        getOpenPojoValidator().validate(PojoClassFactory.getPojoClass(ShoppingCenterOut.class));
    }
}
