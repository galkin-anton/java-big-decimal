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
package org.test.streamApi;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONStringer;
import org.test.streamApi.model.RiskRecord;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Project: TestTest
 * Author: Galkin A.B.
 * Date: 16.03.2020
 * Time: 10:04
 * Descriptions
 */

public class StreamApi {
    private List<String> ids = Arrays.asList("test1", "test3");
    private List<RiskRecord> rr = Arrays.asList(
            new RiskRecord("test", "test", Timestamp.valueOf(LocalDateTime.parse("2020-01-01T20:20:20.000"))),
            new RiskRecord("test1", "test1", Timestamp.valueOf(LocalDateTime.parse("2020-01-01T20:21:20.000"))),
            new RiskRecord("test1", "process", Timestamp.valueOf(LocalDateTime.parse("2020-01-01T20:22:20.000"))),
            new RiskRecord("test1", "process2", Timestamp.valueOf(LocalDateTime.parse("2020-01-01T20:22:20.000"))),
            new RiskRecord("test1", "process2", Timestamp.valueOf(LocalDateTime.parse("2020-01-01T20:23:20.000"))),
            new RiskRecord("test3", "test1", Timestamp.valueOf(LocalDateTime.parse("2020-01-01T20:21:20.000")))
    );

    public static void main(String... args) {
        StreamApi sa = new StreamApi();
        sa.grouping();
        sa.selectByBusinessProcessId("test1");
        sa.filterInOtherList();
        String businessProcessIds = "edv,gg";
        List<String> businessProcessList;
        String operation;
        int idx = businessProcessIds.indexOf(":");
        operation = businessProcessIds.substring(0, idx == -1 ? 0 : idx);
        operation = StringUtils.isEmpty(operation) ? "eq" : operation;
        businessProcessList = Arrays.asList(businessProcessIds.substring(idx + 1).split(","));

        System.out.println(StringUtils.isEmpty(operation));
        System.out.println(businessProcessList);

        sa.groupingAndMax();
    }

    private void grouping() {
        System.out.println("---Grouping BY---");
        System.out.println(rr);
        //rr.stream().collect()
    }

    private void filterInOtherList() {
        List<RiskRecord> c = rr.stream().filter(r -> ids.contains(r.getObjectId())).collect(Collectors.toList());
        System.out.println("---Filter by ids---");
        System.out.println(c);
    }

    private void selectByBusinessProcessId(String businessProcessId) {
        System.out.printf("---Select by businessProcessId = %s ---%n", businessProcessId);
        List<RiskRecord> c = rr.parallelStream().filter(r -> r.getBusinessProcessId().equals(businessProcessId))
                .collect(Collectors.toList());
        System.out.println(c);
        Map<String, List<RiskRecord>> c2 = rr.stream().collect(Collectors.groupingBy(RiskRecord::getBusinessProcessId));
        System.out.println(c2);
    }

    private void groupingAndMax() {
        System.out.println("---Grouping BY and MAX---");
        System.out.println(rr);
        Map<String, Map<String, Optional<RiskRecord>>> collect = rr.stream().filter(r -> r.getObjectId().equals("test1"))
                .collect(Collectors.groupingBy(RiskRecord::getObjectId, /*Collectors.maxBy((o1, o2) ->
                        o1.getDateTimeCalcGMT().toLocalDateTime().compareTo(o2.getDateTimeCalcGMT().toLocalDateTime())
                )*/
                        Collectors.groupingBy(RiskRecord::getBusinessProcessId,
                                Collectors.maxBy(Comparator.comparing(o -> o.getDateTimeCalcGMT().toLocalDateTime())))
                ));
        System.out.println(JSONStringer.valueToString(collect));
        RiskRecord riskRecord = collect.get("test1").get("process2").get();
        List<List<RiskRecord>> collect1 =
                collect.entrySet().stream().map(r -> r.getValue().entrySet().stream().map(o -> o.getValue().get()).collect(Collectors.toList()))
                        .collect(Collectors.toList());
        List<RiskRecord> collect2 = collect1.stream().collect(Collector.of(ArrayList::new, ArrayList::addAll, (left, right) -> {
            left.addAll(right.stream().collect(Collectors.toList()));
            return left;
        }));
        System.out.println(JSONStringer.valueToString(collect2));
    }
}
