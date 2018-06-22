package com.daklan.budget.control.rest.pojotest;

import com.daklan.budget.control.rest.dto.output.ItemOut;
import com.daklan.budget.control.rest.pojotest.mainpojotestclasses.AbstractBeanTest;
import com.openpojo.reflection.impl.PojoClassFactory;
import org.junit.Test;

public class ItemOutTest extends AbstractBeanTest {

    @Test
    public void testPojoWithOpenpojo() {
        getOpenPojoValidator().validate(PojoClassFactory.getPojoClass(ItemOut.class));
    }
}
