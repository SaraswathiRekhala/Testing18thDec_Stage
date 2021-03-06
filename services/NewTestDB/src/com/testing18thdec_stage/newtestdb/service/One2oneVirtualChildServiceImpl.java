/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing18thdec_stage.newtestdb.service;

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

import com.testing18thdec_stage.newtestdb.One2oneVirtualChild;
import com.testing18thdec_stage.newtestdb.One2oneVirtualChildId;


/**
 * ServiceImpl object for domain model class One2oneVirtualChild.
 *
 * @see One2oneVirtualChild
 */
@Service("NewTestDB.One2oneVirtualChildService")
@Validated
public class One2oneVirtualChildServiceImpl implements One2oneVirtualChildService {

    private static final Logger LOGGER = LoggerFactory.getLogger(One2oneVirtualChildServiceImpl.class);


    @Autowired
    @Qualifier("NewTestDB.One2oneVirtualChildDao")
    private WMGenericDao<One2oneVirtualChild, One2oneVirtualChildId> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<One2oneVirtualChild, One2oneVirtualChildId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "NewTestDBTransactionManager")
    @Override
	public One2oneVirtualChild create(One2oneVirtualChild one2oneVirtualChild) {
        LOGGER.debug("Creating a new One2oneVirtualChild with information: {}", one2oneVirtualChild);

        One2oneVirtualChild one2oneVirtualChildCreated = this.wmGenericDao.create(one2oneVirtualChild);
        return one2oneVirtualChildCreated;
    }

	@Transactional(readOnly = true, value = "NewTestDBTransactionManager")
	@Override
	public One2oneVirtualChild getById(One2oneVirtualChildId one2onevirtualchildId) throws EntityNotFoundException {
        LOGGER.debug("Finding One2oneVirtualChild by id: {}", one2onevirtualchildId);
        One2oneVirtualChild one2oneVirtualChild = this.wmGenericDao.findById(one2onevirtualchildId);
        if (one2oneVirtualChild == null){
            LOGGER.debug("No One2oneVirtualChild found with id: {}", one2onevirtualchildId);
            throw new EntityNotFoundException(String.valueOf(one2onevirtualchildId));
        }
        return one2oneVirtualChild;
    }

    @Transactional(readOnly = true, value = "NewTestDBTransactionManager")
	@Override
	public One2oneVirtualChild findById(One2oneVirtualChildId one2onevirtualchildId) {
        LOGGER.debug("Finding One2oneVirtualChild by id: {}", one2onevirtualchildId);
        return this.wmGenericDao.findById(one2onevirtualchildId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "NewTestDBTransactionManager")
	@Override
	public One2oneVirtualChild update(One2oneVirtualChild one2oneVirtualChild) throws EntityNotFoundException {
        LOGGER.debug("Updating One2oneVirtualChild with information: {}", one2oneVirtualChild);
        this.wmGenericDao.update(one2oneVirtualChild);

        One2oneVirtualChildId one2onevirtualchildId = new One2oneVirtualChildId();
        one2onevirtualchildId.setCharId(one2oneVirtualChild.getCharId());
        one2onevirtualchildId.setStringCol(one2oneVirtualChild.getStringCol());
        one2onevirtualchildId.setBooleanCol(one2oneVirtualChild.getBooleanCol());
        one2onevirtualchildId.setDateCol(one2oneVirtualChild.getDateCol());

        return this.wmGenericDao.findById(one2onevirtualchildId);
    }

    @Transactional(value = "NewTestDBTransactionManager")
	@Override
	public One2oneVirtualChild delete(One2oneVirtualChildId one2onevirtualchildId) throws EntityNotFoundException {
        LOGGER.debug("Deleting One2oneVirtualChild with id: {}", one2onevirtualchildId);
        One2oneVirtualChild deleted = this.wmGenericDao.findById(one2onevirtualchildId);
        if (deleted == null) {
            LOGGER.debug("No One2oneVirtualChild found with id: {}", one2onevirtualchildId);
            throw new EntityNotFoundException(String.valueOf(one2onevirtualchildId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "NewTestDBTransactionManager")
	@Override
	public Page<One2oneVirtualChild> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all One2oneVirtualChilds");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "NewTestDBTransactionManager")
    @Override
    public Page<One2oneVirtualChild> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all One2oneVirtualChilds");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "NewTestDBTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service NewTestDB for table One2oneVirtualChild to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "NewTestDBTransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "NewTestDBTransactionManager")
	@Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}

