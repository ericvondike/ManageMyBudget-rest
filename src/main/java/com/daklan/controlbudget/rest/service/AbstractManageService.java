package com.daklan.controlbudget.rest.service;

import com.daklan.controlbudget.rest.model.dto.output.RecordCreateDtoOut;
import com.daklan.controlbudget.rest.model.dto.output.RecordDeleteDtoOut;
import com.daklan.controlbudget.rest.model.dto.output.RecordUpdateDtoOut;
import com.daklan.controlbudget.rest.model.enums.ContactUse;
import com.daklan.controlbudget.rest.service.impl.ExceptionManageMyBudgetService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <b>The abstract class for the common methods on all services.</b>
 */
public abstract class AbstractManageService {

    @Autowired
    private ExceptionManageMyBudgetService exceptionManageMyBudgetService;


    /**
     *
     * @param idRecord the id of the record to be created.
     * @return recordDeleteDtoOut: contains the id of the record have been created and a message.
     */
    public RecordCreateDtoOut buildRecordCreateDtoOut(String idRecord) {
        final RecordCreateDtoOut recordCreateDtoOut = new RecordCreateDtoOut(idRecord);
        return recordCreateDtoOut;
    }

    public RecordUpdateDtoOut buildRecordUpdateDtoOut(String id) {
        final RecordUpdateDtoOut recordUpdateDtoOut = new RecordUpdateDtoOut(id);
        return recordUpdateDtoOut;
    }

    /**
     * <b>The method for constructing the DTOout for deleting a record.</b>
     * @param idRecord the id of the record to be deleted.
     * @return recordDeleteDtoOut: contains the id of the record have been deleted and a message.
     */
    public RecordDeleteDtoOut buildRecordDeletDtoOut(String idRecord) {
        final RecordDeleteDtoOut recordDeleteDtoOut = new RecordDeleteDtoOut(idRecord);
        return recordDeleteDtoOut;
    }

    public ContactUse convertStringContactUseToEnumContactUse(String strContactUse) {

        switch (strContactUse) {
            case "PERSPNEL" :
                return ContactUse.PERSONAL;
            case "PROFESSIONAL":
                return ContactUse.PROFESSIONAL;
            default:
                exceptionManageMyBudgetService.throwContactUseNotFoundException(strContactUse);
        }
        return null;
    }
}
