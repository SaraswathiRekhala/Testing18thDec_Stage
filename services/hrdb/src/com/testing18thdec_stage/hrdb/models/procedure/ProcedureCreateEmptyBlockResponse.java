/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing18thdec_stage.hrdb.models.procedure;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class ProcedureCreateEmptyBlockResponse implements Serializable {


    @ColumnAlias("B_ADDR")
    private Integer baddr;

    public Integer getBaddr() {
        return this.baddr;
    }

    public void setBaddr(Integer baddr) {
        this.baddr = baddr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProcedureCreateEmptyBlockResponse)) return false;
        final ProcedureCreateEmptyBlockResponse procedureCreateEmptyBlockResponse = (ProcedureCreateEmptyBlockResponse) o;
        return Objects.equals(getBaddr(), procedureCreateEmptyBlockResponse.getBaddr());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBaddr());
    }
}