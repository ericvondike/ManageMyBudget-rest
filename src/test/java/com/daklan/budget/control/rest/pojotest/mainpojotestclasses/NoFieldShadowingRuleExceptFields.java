package com.daklan.budget.control.rest.pojotest.mainpojotestclasses;

import com.openpojo.log.utils.MessageFormatter;
import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.PojoField;
import com.openpojo.validation.affirm.Affirm;
import com.openpojo.validation.rule.Rule;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NoFieldShadowingRuleExceptFields implements Rule {

    private final List<String> exceptFieldnames;

    NoFieldShadowingRuleExceptFields(String... exceptFieldnames) {
        super();
        this.exceptFieldnames = Arrays.asList(exceptFieldnames);
    }

    public void evaluate(final PojoClass pojoClass) {
        final List<PojoField> parentPojoFields = new LinkedList<>();
        PojoClass parentPojoClass = pojoClass.getSuperClass();
        while (parentPojoClass != null) {
            parentPojoFields.addAll(parentPojoClass.getPojoFields());
            parentPojoClass = parentPojoClass.getSuperClass();
        }
        final List<PojoField> childPojoFields = pojoClass.getPojoFields();
        for (final PojoField childPojoField : childPojoFields) {
            if (contains(childPojoField.getName(), parentPojoFields)) {
                Affirm.fail(MessageFormatter.format("Field=[{0}] shadows field with the same name in parent class=[{1}]",
                        childPojoField, parentPojoFields));
            }
        }
    }

    private boolean contains(final String fieldName, final List<PojoField> pojoFields) {
        if (exceptFieldnames.contains(fieldName)) {
            return false;
        }
        for (final PojoField pojoField : pojoFields) {
            if (pojoField.getName().equals(fieldName)) {

                return true;
            }
        }

        return false;
    }
}