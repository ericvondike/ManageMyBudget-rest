package com.daklan.controlbudget.rest.service;

import com.daklan.controlbudget.rest.model.dto.contactinformation.RecordCreateDtoOut;
import com.daklan.controlbudget.rest.model.dto.contactinformation.RecordDeleteDtoOut;
import com.daklan.controlbudget.rest.model.dto.contactinformation.RecordUpdateDtoOut;

/**
 * <b>The abstract class for the common methods on all services.</b>
 */
public abstract class AbstractManageService {


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
}
