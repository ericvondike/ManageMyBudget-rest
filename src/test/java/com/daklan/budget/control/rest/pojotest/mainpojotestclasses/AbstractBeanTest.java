package com.daklan.budget.control.rest.pojotest.mainpojotestclasses;


import java.time.LocalDate;

import static com.google.code.beanmatchers.BeanMatchers.*;
import static org.junit.Assert.assertThat;

import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;
import com.openpojo.validation.rule.impl.*;

public abstract class AbstractBeanTest {

    public Validator getOpenPojoValidator() {
        final ValidatorBuilder validatorBuilder = ValidatorBuilder.create();
        // Rules
        validatorBuilder.getRules().add(new GetterMustExistRule());
        validatorBuilder.getRules().add(new NoNestedClassRule());
        validatorBuilder.getRules().add(new NoPrimitivesRule());
        validatorBuilder.getRules().add(new NoPublicFieldsExceptStaticFinalRule());
        validatorBuilder.getRules().add(new NoPublicFieldsRule());
        validatorBuilder.getRules().add(new NoFieldShadowingRuleExceptFields("serialVersionUID"));
        validatorBuilder.getRules().add(new NoStaticExceptFinalRule());
        validatorBuilder.getRules().add(new SerializableMustHaveSerialVersionUIDRule());
        validatorBuilder.getRules().add(new SetterMustExistRule());
        // Tester
        validatorBuilder.getTesters().add(new DefaultValuesNullExceptListAndMapTester());
        validatorBuilder.getTesters().add(new SetterTester());
        validatorBuilder.getTesters().add(new GetterTester());
        return validatorBuilder.build();
    }

    void testPojoWithBeanMatchers(Class<?> clazz) {
        registerValueGenerator(new LocalDateValueGenerator(), LocalDate.class);

        assertThat(clazz, hasValidBeanConstructor());
        assertThat(clazz, hasValidBeanEquals());
        assertThat(clazz, hasValidBeanHashCode());
        assertThat(clazz, hasValidGettersAndSetters());
        assertThat(clazz, hasValidBeanToString());
    }

    protected void testPojoWithBeanMatchers(Class<?> clazz, String... excludingProperties) {
        registerValueGenerator(new LocalDateValueGenerator(), LocalDate.class);

        assertThat(clazz, hasValidBeanConstructor());
        assertThat(clazz, hasValidBeanEqualsExcluding(excludingProperties));
        assertThat(clazz, hasValidBeanHashCodeExcluding(excludingProperties));
        assertThat(clazz, hasValidGettersAndSettersExcluding(excludingProperties));
        assertThat(clazz, hasValidBeanToStringExcluding(excludingProperties));
    }
}
