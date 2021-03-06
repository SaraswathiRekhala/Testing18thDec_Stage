/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing18thdec_stage.newtestdb;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

public class Many2oneCompChild1Id implements Serializable {

    private String stringId;
    private Long bigintId;

    public String getStringId() {
        return this.stringId;
    }

    public void setStringId(String stringId) {
        this.stringId = stringId;
    }

    public Long getBigintId() {
        return this.bigintId;
    }

    public void setBigintId(Long bigintId) {
        this.bigintId = bigintId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Many2oneCompChild1)) return false;
        final Many2oneCompChild1 many2oneCompChild1 = (Many2oneCompChild1) o;
        return Objects.equals(getStringId(), many2oneCompChild1.getStringId()) &&
                Objects.equals(getBigintId(), many2oneCompChild1.getBigintId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStringId(),
                getBigintId());
    }
}
