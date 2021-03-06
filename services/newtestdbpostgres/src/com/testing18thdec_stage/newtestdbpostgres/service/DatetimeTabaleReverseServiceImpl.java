/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing18thdec_stage.newtestdbpostgres.service;

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

import com.testing18thdec_stage.newtestdbpostgres.DatetimeTabaleReverse;


/**
 * ServiceImpl object for domain model class DatetimeTabaleReverse.
 *
 * @see DatetimeTabaleReverse
 */
@Service("newtestdbpostgres.DatetimeTabaleReverseService")
@Validated
public class DatetimeTabaleReverseServiceImpl implements DatetimeTabaleReverseService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatetimeTabaleReverseServiceImpl.class);


    @Autowired
    @Qualifier("newtestdbpostgres.DatetimeTabaleReverseDao")
    private WMGenericDao<DatetimeTabaleReverse, String> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<DatetimeTabaleReverse, String> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "newtestdbpostgresTransactionManager")
    @Override
	public DatetimeTabaleReverse create(DatetimeTabaleReverse datetimeTabaleReverse) {
        LOGGER.debug("Creating a new DatetimeTabaleReverse with information: {}", datetimeTabaleReverse);

        DatetimeTabaleReverse datetimeTabaleReverseCreated = this.wmGenericDao.create(datetimeTabaleReverse);
        return datetimeTabaleReverseCreated;
    }

	@Transactional(readOnly = true, value = "newtestdbpostgresTransactionManager")
	@Override
	public DatetimeTabaleReverse getById(String datetimetabalereverseId) throws EntityNotFoundException {
        LOGGER.debug("Finding DatetimeTabaleReverse by id: {}", datetimetabalereverseId);
        DatetimeTabaleReverse datetimeTabaleReverse = this.wmGenericDao.findById(datetimetabalereverseId);
        if (datetimeTabaleReverse == null){
            LOGGER.debug("No DatetimeTabaleReverse found with id: {}", datetimetabalereverseId);
            throw new EntityNotFoundException(String.valueOf(datetimetabalereverseId));
        }
        return datetimeTabaleReverse;
    }

    @Transactional(readOnly = true, value = "newtestdbpostgresTransactionManager")
	@Override
	public DatetimeTabaleReverse findById(String datetimetabalereverseId) {
        LOGGER.debug("Finding DatetimeTabaleReverse by id: {}", datetimetabalereverseId);
        return this.wmGenericDao.findById(datetimetabalereverseId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "newtestdbpostgresTransactionManager")
	@Override
	public DatetimeTabaleReverse update(DatetimeTabaleReverse datetimeTabaleReverse) throws EntityNotFoundException {
        LOGGER.debug("Updating DatetimeTabaleReverse with information: {}", datetimeTabaleReverse);
        this.wmGenericDao.update(datetimeTabaleReverse);

        String datetimetabalereverseId = datetimeTabaleReverse.getId();

        return this.wmGenericDao.findById(datetimetabalereverseId);
    }

    @Transactional(value = "newtestdbpostgresTransactionManager")
	@Override
	public DatetimeTabaleReverse delete(String datetimetabalereverseId) throws EntityNotFoundException {
        LOGGER.debug("Deleting DatetimeTabaleReverse with id: {}", datetimetabalereverseId);
        DatetimeTabaleReverse deleted = this.wmGenericDao.findById(datetimetabalereverseId);
        if (deleted == null) {
            LOGGER.debug("No DatetimeTabaleReverse found with id: {}", datetimetabalereverseId);
            throw new EntityNotFoundException(String.valueOf(datetimetabalereverseId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "newtestdbpostgresTransactionManager")
	@Override
	public Page<DatetimeTabaleReverse> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all DatetimeTabaleReverses");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "newtestdbpostgresTransactionManager")
    @Override
    public Page<DatetimeTabaleReverse> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all DatetimeTabaleReverses");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "newtestdbpostgresTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service newtestdbpostgres for table DatetimeTabaleReverse to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "newtestdbpostgresTransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "newtestdbpostgresTransactionManager")
	@Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}

