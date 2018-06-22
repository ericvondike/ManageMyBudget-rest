package com.daklan.budget.control.rest.pojotest;

import com.daklan.budget.control.rest.dto.input.ItemIn;
import com.daklan.budget.control.rest.pojotest.mainpojotestclasses.AbstractBeanTest;
import com.openpojo.reflection.impl.PojoClassFactory;
import org.junit.Test;

public class ItemInTest extends AbstractBeanTest {

    @Test
    public void testPojoWithOpenpoje() {
        getOpenPojoValidator().validate(PojoClassFactory.getPojoClass(ItemIn.class));
    }
}
