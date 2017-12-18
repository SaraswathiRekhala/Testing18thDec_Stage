/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing18thdec_stage.newtestdb.dao;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.wavemaker.runtime.data.dao.WMGenericDaoImpl;

import com.testing18thdec_stage.newtestdb.DatabasedefinedTable;
import com.testing18thdec_stage.newtestdb.DatabasedefinedTableId;

/**
 * Specifies methods used to obtain and modify DatabasedefinedTable related information
 * which is stored in the database.
 */
@Repository("NewTestDB.DatabasedefinedTableDao")
public class DatabasedefinedTableDao extends WMGenericDaoImpl<DatabasedefinedTable, DatabasedefinedTableId> {

    @Autowired
    @Qualifier("NewTestDBTemplate")
    private HibernateTemplate template;

    public HibernateTemplate getTemplate() {
        return this.template;
    }
}
