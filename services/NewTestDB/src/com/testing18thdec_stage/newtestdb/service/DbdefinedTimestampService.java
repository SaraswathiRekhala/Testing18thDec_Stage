/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing18thdec_stage.newtestdb.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.testing18thdec_stage.newtestdb.DbdefinedTimestamp;
import com.testing18thdec_stage.newtestdb.DbdefinedTimestampId;

/**
 * Service object for domain model class {@link DbdefinedTimestamp}.
 */
public interface DbdefinedTimestampService {

    /**
     * Creates a new DbdefinedTimestamp. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on DbdefinedTimestamp if any.
     *
     * @param dbdefinedTimestamp Details of the DbdefinedTimestamp to be created; value cannot be null.
     * @return The newly created DbdefinedTimestamp.
     */
	DbdefinedTimestamp create(@Valid DbdefinedTimestamp dbdefinedTimestamp);


	/**
	 * Returns DbdefinedTimestamp by given id if exists.
	 *
	 * @param dbdefinedtimestampId The id of the DbdefinedTimestamp to get; value cannot be null.
	 * @return DbdefinedTimestamp associated with the given dbdefinedtimestampId.
     * @throws EntityNotFoundException If no DbdefinedTimestamp is found.
	 */
	DbdefinedTimestamp getById(DbdefinedTimestampId dbdefinedtimestampId) throws EntityNotFoundException;

    /**
	 * Find and return the DbdefinedTimestamp by given id if exists, returns null otherwise.
	 *
	 * @param dbdefinedtimestampId The id of the DbdefinedTimestamp to get; value cannot be null.
	 * @return DbdefinedTimestamp associated with the given dbdefinedtimestampId.
	 */
	DbdefinedTimestamp findById(DbdefinedTimestampId dbdefinedtimestampId);


	/**
	 * Updates the details of an existing DbdefinedTimestamp. It replaces all fields of the existing DbdefinedTimestamp with the given dbdefinedTimestamp.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on DbdefinedTimestamp if any.
     *
	 * @param dbdefinedTimestamp The details of the DbdefinedTimestamp to be updated; value cannot be null.
	 * @return The updated DbdefinedTimestamp.
	 * @throws EntityNotFoundException if no DbdefinedTimestamp is found with given input.
	 */
	DbdefinedTimestamp update(@Valid DbdefinedTimestamp dbdefinedTimestamp) throws EntityNotFoundException;

    /**
	 * Deletes an existing DbdefinedTimestamp with the given id.
	 *
	 * @param dbdefinedtimestampId The id of the DbdefinedTimestamp to be deleted; value cannot be null.
	 * @return The deleted DbdefinedTimestamp.
	 * @throws EntityNotFoundException if no DbdefinedTimestamp found with the given id.
	 */
	DbdefinedTimestamp delete(DbdefinedTimestampId dbdefinedtimestampId) throws EntityNotFoundException;

	/**
	 * Find all DbdefinedTimestamps matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching DbdefinedTimestamps.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<DbdefinedTimestamp> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all DbdefinedTimestamps matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching DbdefinedTimestamps.
     *
     * @see Pageable
     * @see Page
	 */
    Page<DbdefinedTimestamp> findAll(String query, Pageable pageable);

    /**
	 * Exports all DbdefinedTimestamps matching the given input query to the given exportType format.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param exportType The format in which to export the data; value cannot be null.
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return The Downloadable file in given export type.
     *
     * @see Pageable
     * @see ExportType
     * @see Downloadable
	 */
    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the DbdefinedTimestamps in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the DbdefinedTimestamp.
	 */
	long count(String query);

	/**
	 * Retrieve aggregated values with matching aggregation info.
     *
     * @param aggregationInfo info related to aggregations.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
	 * @return Paginated data with included fields.

     * @see AggregationInfo
     * @see Pageable
     * @see Page
	 */
	Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable);


}
