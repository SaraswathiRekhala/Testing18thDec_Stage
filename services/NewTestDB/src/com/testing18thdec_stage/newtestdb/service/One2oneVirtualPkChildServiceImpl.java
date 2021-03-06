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

import com.testing18thdec_stage.newtestdb.One2oneVirtualPkChild;
import com.testing18thdec_stage.newtestdb.One2oneVirtualPkChildId;


/**
 * ServiceImpl object for domain model class One2oneVirtualPkChild.
 *
 * @see One2oneVirtualPkChild
 */
@Service("NewTestDB.One2oneVirtualPkChildService")
@Validated
public class One2oneVirtualPkChildServiceImpl implements One2oneVirtualPkChildService {

    private static final Logger LOGGER = LoggerFactory.getLogger(One2oneVirtualPkChildServiceImpl.class);


    @Autowired
    @Qualifier("NewTestDB.One2oneVirtualPkChildDao")
    private WMGenericDao<One2oneVirtualPkChild, One2oneVirtualPkChildId> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<One2oneVirtualPkChild, One2oneVirtualPkChildId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "NewTestDBTransactionManager")
    @Override
	public One2oneVirtualPkChild create(One2oneVirtualPkChild one2oneVirtualPkChild) {
        LOGGER.debug("Creating a new One2oneVirtualPkChild with information: {}", one2oneVirtualPkChild);

        One2oneVirtualPkChild one2oneVirtualPkChildCreated = this.wmGenericDao.create(one2oneVirtualPkChild);
        return one2oneVirtualPkChildCreated;
    }

	@Transactional(readOnly = true, value = "NewTestDBTransactionManager")
	@Override
	public One2oneVirtualPkChild getById(One2oneVirtualPkChildId one2onevirtualpkchildId) throws EntityNotFoundException {
        LOGGER.debug("Finding One2oneVirtualPkChild by id: {}", one2onevirtualpkchildId);
        One2oneVirtualPkChild one2oneVirtualPkChild = this.wmGenericDao.findById(one2onevirtualpkchildId);
        if (one2oneVirtualPkChild == null){
            LOGGER.debug("No One2oneVirtualPkChild found with id: {}", one2onevirtualpkchildId);
            throw new EntityNotFoundException(String.valueOf(one2onevirtualpkchildId));
        }
        return one2oneVirtualPkChild;
    }

    @Transactional(readOnly = true, value = "NewTestDBTransactionManager")
	@Override
	public One2oneVirtualPkChild findById(One2oneVirtualPkChildId one2onevirtualpkchildId) {
        LOGGER.debug("Finding One2oneVirtualPkChild by id: {}", one2onevirtualpkchildId);
        return this.wmGenericDao.findById(one2onevirtualpkchildId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "NewTestDBTransactionManager")
	@Override
	public One2oneVirtualPkChild update(One2oneVirtualPkChild one2oneVirtualPkChild) throws EntityNotFoundException {
        LOGGER.debug("Updating One2oneVirtualPkChild with information: {}", one2oneVirtualPkChild);
        this.wmGenericDao.update(one2oneVirtualPkChild);

        One2oneVirtualPkChildId one2onevirtualpkchildId = new One2oneVirtualPkChildId();
        one2onevirtualpkchildId.setCharPkId(one2oneVirtualPkChild.getCharPkId());
        one2onevirtualpkchildId.setStringCol1(one2oneVirtualPkChild.getStringCol1());
        one2onevirtualpkchildId.setStringCol2(one2oneVirtualPkChild.getStringCol2());
        one2onevirtualpkchildId.setCharCol(one2oneVirtualPkChild.getCharCol());

        return this.wmGenericDao.findById(one2onevirtualpkchildId);
    }

    @Transactional(value = "NewTestDBTransactionManager")
	@Override
	public One2oneVirtualPkChild delete(One2oneVirtualPkChildId one2onevirtualpkchildId) throws EntityNotFoundException {
        LOGGER.debug("Deleting One2oneVirtualPkChild with id: {}", one2onevirtualpkchildId);
        One2oneVirtualPkChild deleted = this.wmGenericDao.findById(one2onevirtualpkchildId);
        if (deleted == null) {
            LOGGER.debug("No One2oneVirtualPkChild found with id: {}", one2onevirtualpkchildId);
            throw new EntityNotFoundException(String.valueOf(one2onevirtualpkchildId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "NewTestDBTransactionManager")
	@Override
	public Page<One2oneVirtualPkChild> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all One2oneVirtualPkChilds");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "NewTestDBTransactionManager")
    @Override
    public Page<One2oneVirtualPkChild> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all One2oneVirtualPkChilds");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "NewTestDBTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service NewTestDB for table One2oneVirtualPkChild to {} format", exportType);
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

