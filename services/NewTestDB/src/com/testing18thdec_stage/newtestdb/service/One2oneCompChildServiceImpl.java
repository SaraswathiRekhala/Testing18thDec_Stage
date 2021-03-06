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

import com.testing18thdec_stage.newtestdb.One2oneCompChild;
import com.testing18thdec_stage.newtestdb.One2oneCompParentId;


/**
 * ServiceImpl object for domain model class One2oneCompChild.
 *
 * @see One2oneCompChild
 */
@Service("NewTestDB.One2oneCompChildService")
@Validated
public class One2oneCompChildServiceImpl implements One2oneCompChildService {

    private static final Logger LOGGER = LoggerFactory.getLogger(One2oneCompChildServiceImpl.class);


    @Autowired
    @Qualifier("NewTestDB.One2oneCompChildDao")
    private WMGenericDao<One2oneCompChild, One2oneCompParentId> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<One2oneCompChild, One2oneCompParentId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "NewTestDBTransactionManager")
    @Override
	public One2oneCompChild create(One2oneCompChild one2oneCompChild) {
        LOGGER.debug("Creating a new One2oneCompChild with information: {}", one2oneCompChild);

        One2oneCompChild one2oneCompChildCreated = this.wmGenericDao.create(one2oneCompChild);
        return one2oneCompChildCreated;
    }

	@Transactional(readOnly = true, value = "NewTestDBTransactionManager")
	@Override
	public One2oneCompChild getById(One2oneCompParentId one2onecompchildId) throws EntityNotFoundException {
        LOGGER.debug("Finding One2oneCompChild by id: {}", one2onecompchildId);
        One2oneCompChild one2oneCompChild = this.wmGenericDao.findById(one2onecompchildId);
        if (one2oneCompChild == null){
            LOGGER.debug("No One2oneCompChild found with id: {}", one2onecompchildId);
            throw new EntityNotFoundException(String.valueOf(one2onecompchildId));
        }
        return one2oneCompChild;
    }

    @Transactional(readOnly = true, value = "NewTestDBTransactionManager")
	@Override
	public One2oneCompChild findById(One2oneCompParentId one2onecompchildId) {
        LOGGER.debug("Finding One2oneCompChild by id: {}", one2onecompchildId);
        return this.wmGenericDao.findById(one2onecompchildId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "NewTestDBTransactionManager")
	@Override
	public One2oneCompChild update(One2oneCompChild one2oneCompChild) throws EntityNotFoundException {
        LOGGER.debug("Updating One2oneCompChild with information: {}", one2oneCompChild);
        this.wmGenericDao.update(one2oneCompChild);

        One2oneCompParentId one2onecompchildId = new One2oneCompParentId();
        one2onecompchildId.setByteId(one2oneCompChild.getByteId());
        one2onecompchildId.setCharId(one2oneCompChild.getCharId());
        one2onecompchildId.setStringId(one2oneCompChild.getStringId());
        one2onecompchildId.setFloatId(one2oneCompChild.getFloatId());

        return this.wmGenericDao.findById(one2onecompchildId);
    }

    @Transactional(value = "NewTestDBTransactionManager")
	@Override
	public One2oneCompChild delete(One2oneCompParentId one2onecompchildId) throws EntityNotFoundException {
        LOGGER.debug("Deleting One2oneCompChild with id: {}", one2onecompchildId);
        One2oneCompChild deleted = this.wmGenericDao.findById(one2onecompchildId);
        if (deleted == null) {
            LOGGER.debug("No One2oneCompChild found with id: {}", one2onecompchildId);
            throw new EntityNotFoundException(String.valueOf(one2onecompchildId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "NewTestDBTransactionManager")
	@Override
	public Page<One2oneCompChild> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all One2oneCompChilds");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "NewTestDBTransactionManager")
    @Override
    public Page<One2oneCompChild> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all One2oneCompChilds");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "NewTestDBTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service NewTestDB for table One2oneCompChild to {} format", exportType);
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

