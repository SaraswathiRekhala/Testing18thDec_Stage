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

import com.testing18thdec_stage.wmstudio.One2oneVpkUcChildChekcst;
import com.testing18thdec_stage.wmstudio.One2oneVpkUcChildChekcstId;


/**
 * ServiceImpl object for domain model class One2oneVpkUcChildChekcst.
 *
 * @see One2oneVpkUcChildChekcst
 */
@Service("WMSTUDIO.One2oneVpkUcChildChekcstService")
@Validated
public class One2oneVpkUcChildChekcstServiceImpl implements One2oneVpkUcChildChekcstService {

    private static final Logger LOGGER = LoggerFactory.getLogger(One2oneVpkUcChildChekcstServiceImpl.class);


    @Autowired
    @Qualifier("WMSTUDIO.One2oneVpkUcChildChekcstDao")
    private WMGenericDao<One2oneVpkUcChildChekcst, One2oneVpkUcChildChekcstId> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<One2oneVpkUcChildChekcst, One2oneVpkUcChildChekcstId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
    @Override
	public One2oneVpkUcChildChekcst create(One2oneVpkUcChildChekcst one2oneVpkUcChildChekcst) {
        LOGGER.debug("Creating a new One2oneVpkUcChildChekcst with information: {}", one2oneVpkUcChildChekcst);

        One2oneVpkUcChildChekcst one2oneVpkUcChildChekcstCreated = this.wmGenericDao.create(one2oneVpkUcChildChekcst);
        return one2oneVpkUcChildChekcstCreated;
    }

	@Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public One2oneVpkUcChildChekcst getById(One2oneVpkUcChildChekcstId one2onevpkucchildchekcstId) throws EntityNotFoundException {
        LOGGER.debug("Finding One2oneVpkUcChildChekcst by id: {}", one2onevpkucchildchekcstId);
        One2oneVpkUcChildChekcst one2oneVpkUcChildChekcst = this.wmGenericDao.findById(one2onevpkucchildchekcstId);
        if (one2oneVpkUcChildChekcst == null){
            LOGGER.debug("No One2oneVpkUcChildChekcst found with id: {}", one2onevpkucchildchekcstId);
            throw new EntityNotFoundException(String.valueOf(one2onevpkucchildchekcstId));
        }
        return one2oneVpkUcChildChekcst;
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public One2oneVpkUcChildChekcst findById(One2oneVpkUcChildChekcstId one2onevpkucchildchekcstId) {
        LOGGER.debug("Finding One2oneVpkUcChildChekcst by id: {}", one2onevpkucchildchekcstId);
        return this.wmGenericDao.findById(one2onevpkucchildchekcstId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "WMSTUDIOTransactionManager")
	@Override
	public One2oneVpkUcChildChekcst update(One2oneVpkUcChildChekcst one2oneVpkUcChildChekcst) throws EntityNotFoundException {
        LOGGER.debug("Updating One2oneVpkUcChildChekcst with information: {}", one2oneVpkUcChildChekcst);
        this.wmGenericDao.update(one2oneVpkUcChildChekcst);

        One2oneVpkUcChildChekcstId one2onevpkucchildchekcstId = new One2oneVpkUcChildChekcstId();
        one2onevpkucchildchekcstId.setCharacterCol(one2oneVpkUcChildChekcst.getCharacterCol());
        one2onevpkucchildchekcstId.setFloatCol(one2oneVpkUcChildChekcst.getFloatCol());
        one2onevpkucchildchekcstId.setSmallintCol(one2oneVpkUcChildChekcst.getSmallintCol());
        one2onevpkucchildchekcstId.setStringCol(one2oneVpkUcChildChekcst.getStringCol());
        one2onevpkucchildchekcstId.setIntegerCol(one2oneVpkUcChildChekcst.getIntegerCol());

        return this.wmGenericDao.findById(one2onevpkucchildchekcstId);
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
	@Override
	public One2oneVpkUcChildChekcst delete(One2oneVpkUcChildChekcstId one2onevpkucchildchekcstId) throws EntityNotFoundException {
        LOGGER.debug("Deleting One2oneVpkUcChildChekcst with id: {}", one2onevpkucchildchekcstId);
        One2oneVpkUcChildChekcst deleted = this.wmGenericDao.findById(one2onevpkucchildchekcstId);
        if (deleted == null) {
            LOGGER.debug("No One2oneVpkUcChildChekcst found with id: {}", one2onevpkucchildchekcstId);
            throw new EntityNotFoundException(String.valueOf(one2onevpkucchildchekcstId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public Page<One2oneVpkUcChildChekcst> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all One2oneVpkUcChildChekcsts");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Page<One2oneVpkUcChildChekcst> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all One2oneVpkUcChildChekcsts");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service WMSTUDIO for table One2oneVpkUcChildChekcst to {} format", exportType);
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
