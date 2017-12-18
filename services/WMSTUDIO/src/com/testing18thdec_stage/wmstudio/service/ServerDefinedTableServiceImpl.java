/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing18thdec_stage.wmstudio.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.testing18thdec_stage.wmstudio.ServerDefinedTable;


/**
 * ServiceImpl object for domain model class ServerDefinedTable.
 *
 * @see ServerDefinedTable
 */
@Service("WMSTUDIO.ServerDefinedTableService")
@Validated
public class ServerDefinedTableServiceImpl implements ServerDefinedTableService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServerDefinedTableServiceImpl.class);


    @Autowired
    @Qualifier("WMSTUDIO.ServerDefinedTableDao")
    private WMGenericDao<ServerDefinedTable, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<ServerDefinedTable, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
    @Override
	public ServerDefinedTable create(ServerDefinedTable serverDefinedTable) {
        LOGGER.debug("Creating a new ServerDefinedTable with information: {}", serverDefinedTable);

        ServerDefinedTable serverDefinedTableCreated = this.wmGenericDao.create(serverDefinedTable);
        return serverDefinedTableCreated;
    }

	@Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public ServerDefinedTable getById(Integer serverdefinedtableId) throws EntityNotFoundException {
        LOGGER.debug("Finding ServerDefinedTable by id: {}", serverdefinedtableId);
        ServerDefinedTable serverDefinedTable = this.wmGenericDao.findById(serverdefinedtableId);
        if (serverDefinedTable == null){
            LOGGER.debug("No ServerDefinedTable found with id: {}", serverdefinedtableId);
            throw new EntityNotFoundException(String.valueOf(serverdefinedtableId));
        }
        return serverDefinedTable;
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public ServerDefinedTable findById(Integer serverdefinedtableId) {
        LOGGER.debug("Finding ServerDefinedTable by id: {}", serverdefinedtableId);
        return this.wmGenericDao.findById(serverdefinedtableId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "WMSTUDIOTransactionManager")
	@Override
	public ServerDefinedTable update(ServerDefinedTable serverDefinedTable) throws EntityNotFoundException {
        LOGGER.debug("Updating ServerDefinedTable with information: {}", serverDefinedTable);
        this.wmGenericDao.update(serverDefinedTable);

        Integer serverdefinedtableId = serverDefinedTable.getSeqId();

        return this.wmGenericDao.findById(serverdefinedtableId);
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
	@Override
	public ServerDefinedTable delete(Integer serverdefinedtableId) throws EntityNotFoundException {
        LOGGER.debug("Deleting ServerDefinedTable with id: {}", serverdefinedtableId);
        ServerDefinedTable deleted = this.wmGenericDao.findById(serverdefinedtableId);
        if (deleted == null) {
            LOGGER.debug("No ServerDefinedTable found with id: {}", serverdefinedtableId);
            throw new EntityNotFoundException(String.valueOf(serverdefinedtableId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public Page<ServerDefinedTable> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all ServerDefinedTables");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Page<ServerDefinedTable> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all ServerDefinedTables");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service WMSTUDIO for table ServerDefinedTable to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}
