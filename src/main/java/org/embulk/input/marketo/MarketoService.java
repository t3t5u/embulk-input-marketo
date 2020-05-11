package org.embulk.input.marketo;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.embulk.input.marketo.model.MarketoField;

import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * Created by tai.khuu on 9/6/17.
 */
public interface MarketoService
{
    List<MarketoField> describeLead();

    File extractLead(Date startTime, Date endTime, List<String> extractedFields, String filterField, int pollingTimeIntervalSecond, int bulkJobTimeoutSecond);

    File extractAllActivity(List<Integer> activityTypeIds, Date startTime, Date endTime, int pollingTimeIntervalSecond, int bulkJobTimeoutSecond);

    Iterable<ObjectNode> getAllListLead(List<String> extractFields);

    Iterable<ObjectNode> getAllProgramLead(List<String> extractFields);

    Iterable<ObjectNode> getCampaign();

    Iterable<ObjectNode> getPrograms();

    Iterable<ObjectNode> getProgramsByTag(String tagType, String tagValue);

    Iterable<ObjectNode> getProgramsByDateRange(Date earliestUpdatedAt, Date latestUpdatedAt, String filterType, List<String> filterValues);

    Iterable<ObjectNode> getCustomObject(String customObjectAPIName, String customObjectFilterType, String customObjectFields, Integer fromValue, Integer toValue);

    List<MarketoField> describeCustomObject(String customObjectAPIName);

    Iterable<ObjectNode> getActivityTypes();

    Iterable<ObjectNode> getLists();
}
