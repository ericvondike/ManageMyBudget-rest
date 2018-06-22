package com.daklan.budget.control.rest.pojotest;

import com.daklan.budget.control.rest.dto.output.CategoryOut;
import com.daklan.budget.control.rest.pojotest.mainpojotestclasses.AbstractBeanTest;
import com.openpojo.reflection.impl.PojoClassFactory;
import org.junit.Test;

public class CategoryOutTest extends AbstractBeanTest {

    @Test
    public void testPojoWithOpenPojo() {
        getOpenPojoValidator().validate(PojoClassFactory.getPojoClass(CategoryOut.class));
    }
}
