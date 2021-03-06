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

import com.testing18thdec_stage.newtestdb.DatabasedefinedTable;
import com.testing18thdec_stage.newtestdb.DatabasedefinedTableId;

/**
 * Service object for domain model class {@link DatabasedefinedTable}.
 */
public interface DatabasedefinedTableService {

    /**
     * Creates a new DatabasedefinedTable. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on DatabasedefinedTable if any.
     *
     * @param databasedefinedTable Details of the DatabasedefinedTable to be created; value cannot be null.
     * @return The newly created DatabasedefinedTable.
     */
	DatabasedefinedTable create(@Valid DatabasedefinedTable databasedefinedTable);


	/**
	 * Returns DatabasedefinedTable by given id if exists.
	 *
	 * @param databasedefinedtableId The id of the DatabasedefinedTable to get; value cannot be null.
	 * @return DatabasedefinedTable associated with the given databasedefinedtableId.
     * @throws EntityNotFoundException If no DatabasedefinedTable is found.
	 */
	DatabasedefinedTable getById(DatabasedefinedTableId databasedefinedtableId) throws EntityNotFoundException;

    /**
	 * Find and return the DatabasedefinedTable by given id if exists, returns null otherwise.
	 *
	 * @param databasedefinedtableId The id of the DatabasedefinedTable to get; value cannot be null.
	 * @return DatabasedefinedTable associated with the given databasedefinedtableId.
	 */
	DatabasedefinedTable findById(DatabasedefinedTableId databasedefinedtableId);


	/**
	 * Updates the details of an existing DatabasedefinedTable. It replaces all fields of the existing DatabasedefinedTable with the given databasedefinedTable.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on DatabasedefinedTable if any.
     *
	 * @param databasedefinedTable The details of the DatabasedefinedTable to be updated; value cannot be null.
	 * @return The updated DatabasedefinedTable.
	 * @throws EntityNotFoundException if no DatabasedefinedTable is found with given input.
	 */
	DatabasedefinedTable update(@Valid DatabasedefinedTable databasedefinedTable) throws EntityNotFoundException;

    /**
	 * Deletes an existing DatabasedefinedTable with the given id.
	 *
	 * @param databasedefinedtableId The id of the DatabasedefinedTable to be deleted; value cannot be null.
	 * @return The deleted DatabasedefinedTable.
	 * @throws EntityNotFoundException if no DatabasedefinedTable found with the given id.
	 */
	DatabasedefinedTable delete(DatabasedefinedTableId databasedefinedtableId) throws EntityNotFoundException;

	/**
	 * Find all DatabasedefinedTables matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching DatabasedefinedTables.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<DatabasedefinedTable> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all DatabasedefinedTables matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching DatabasedefinedTables.
     *
     * @see Pageable
     * @see Page
	 */
    Page<DatabasedefinedTable> findAll(String query, Pageable pageable);

    /**
	 * Exports all DatabasedefinedTables matching the given input query to the given exportType format.
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
	 * Retrieve the count of the DatabasedefinedTables in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the DatabasedefinedTable.
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

