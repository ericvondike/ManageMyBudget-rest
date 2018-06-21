package com.daklan.budget.control.rest.pojotest.mainpojotestclasses;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.PojoField;
import com.openpojo.validation.affirm.Affirm;
import com.openpojo.validation.test.Tester;
import com.openpojo.validation.utils.ValidationHelper;

import java.util.List;
import java.util.Map;

public class DefaultValuesNullExceptListAndMapTester implements Tester {

    public void run(final PojoClass pojoClass) {
        final Object classInstance = ValidationHelper.getBasicInstance(pojoClass);

        for (final PojoField fieldEntry : pojoClass.getPojoFields()) {
            if (!fieldEntry.isPrimitive() && !fieldEntry.isFinal()
                    && !List.class.isAssignableFrom(fieldEntry.getType())
                    && !Map.class.isAssignableFrom(fieldEntry.getType())) {
                Affirm.affirmNull(String.format("Expected null value for for field=[%s]", fieldEntry),
                        fieldEntry.get(classInstance));
            }
        }
    }

}
