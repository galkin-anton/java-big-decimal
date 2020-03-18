/*
 * Copyright (c) 2008-2020
 * Sberbank
 * All rights reserved.
 *
 * This product and related documentation are protected by copyright and
 * distributed under licenses restricting its use, copying, distribution, and
 * decompilation. No part of this product or related documentation may be
 * reproduced in any form by any means without prior written authorization of
 * Sberbank and its licensors, if any.
 *
 * $
 */
package org.test.streamApi.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * Project: TestTest
 * Author: Galkin A.B.
 * Date: 16.03.2020
 * Time: 10:06
 * Descriptions
 */
@Data
@NoArgsConstructor
public class RiskRecord {
    private String objectId;
    private String businessProcessId;
    private String businessProcessType;
    private Timestamp updateDateTime;
    private String xml;
    private Timestamp dateTimeCalcGMT;
    private String idCalc;
    private String riskTypeID;
    public RiskRecord(String objectId, String businessProcessId, Timestamp dateTimeCalcGMT) {
        this.objectId = objectId;
        this.businessProcessId = businessProcessId;
        this.dateTimeCalcGMT = dateTimeCalcGMT;
    }
}
