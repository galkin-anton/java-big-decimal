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
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONStringer;
import org.test.streamApi.model.RiskRecord;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;
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
    private static Logger streamApiLogger = LogManager.getLogger();
    private List<String> ids = Arrays.asList("test1", "test3");
    private List<RiskRecord> rr = Arrays.asList(
            new RiskRecord("d712c663-8650-4253-b512-21661d9adfe6", "test1", Timestamp.valueOf(LocalDateTime.parse("2020-03-17T17:59:01.652")),
                    Timestamp.valueOf(LocalDateTime.parse("2020-03-13T10:38:13.798")), "R_1", "RA-2623"),
            new RiskRecord("d712c663-8650-4253-b512-21661d9adfe6", "test1", Timestamp.valueOf(LocalDateTime.parse("2020-03-17T17:56:01.652")),
                    Timestamp.valueOf(LocalDateTime.parse("2020-03-13T10:38:14.798")), "R_1", "RA-2623"),
            new RiskRecord("d712c663-8650-4253-b512-21661d9adfe6", "test1", Timestamp.valueOf(LocalDateTime.parse("2020-03-17T17:56:01.652")),
                    Timestamp.valueOf(LocalDateTime.parse("2020-03-13T10:38:13.799")), "R_2", "RA-2623"),
            new RiskRecord("d712c663-8650-4253-b512-21661d9adfe6", "test1", Timestamp.valueOf(LocalDateTime.parse("2020-03-17T17:56:01.652")),
                    Timestamp.valueOf(LocalDateTime.parse("2020-03-13T10:37:13.799")), "R_2", "RA-2623"),
            new RiskRecord("d712c663-8650-4253-b512-21661d9adfe6", "test1", Timestamp.valueOf(LocalDateTime.parse("2020-03-17T17:55:01.652")),
                    Timestamp.valueOf(LocalDateTime.parse("2020-03-13T10:38:13.800")), "R_3", "RA-2623"),
            new RiskRecord("d712c663-8650-4253-b512-21661d9adfe6", "test2", Timestamp.valueOf(LocalDateTime.parse("2020-03-17T18:55:01.652")),
                    Timestamp.valueOf(LocalDateTime.parse("2020-03-13T10:38:13.800")), "R_4", "RA-2623")

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
        try {
            System.out.println(ZonedDateTime.parse(""));
        } catch (DateTimeParseException e) {
            streamApiLogger.log(Level.ERROR, e);

        } catch (NullPointerException e) {
            streamApiLogger.log(Level.ERROR, e);
           
        }
    }

    private void print(Object... args) {
        Arrays.stream(args).map(o -> o instanceof String ? o : JSONStringer.valueToString(o)).forEach(System.out::println);
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
        Map<String, Map<String, Optional<RiskRecord>>> collect;
        try {

            collect = rr.stream()
                    .collect(Collectors.groupingBy(RiskRecord::getBusinessProcessId,
                            Collectors.groupingBy(RiskRecord::getRiskTypeID,
                                    Collectors.maxBy(new CompareRiskRecords())
                            )));
            System.out.println(JSONStringer.valueToString(collect));
            //RiskRecord riskRecord = collect.get("test1").get("process2").get();

            List<List<RiskRecord>> collect1 =
                    collect.entrySet().stream().map(r -> r.getValue().entrySet().stream().map(o -> o.getValue().get()).collect(Collectors.toList()))
                            .collect(Collectors.toList());
            List<RiskRecord> collect2 = collect1.stream().collect(Collector.of(ArrayList::new, ArrayList::addAll, (left, right) -> {
                left.addAll(right.stream().collect(Collectors.toList()));
                return left;
            }));
            System.out.println(JSONStringer.valueToString(collect2));
            List<RiskRecord> collect3 =
                    collect.entrySet().stream().flatMap(o -> o.getValue().entrySet().stream()).map(o -> o.getValue().get()).collect(Collectors.toList());
            System.out.println(JSONStringer.valueToString(collect3));
        } catch (NullPointerException e) {
            System.out.println(e);
        }
        //v2
        print("---Grouping v2 for Risk---");
        //Группируем по businessProcessId и RiskID и выбираем последние по dateTimeCalc
        collect = rr.parallelStream()
                .collect(Collectors.groupingBy(RiskRecord::getBusinessProcessId,
                        Collectors.groupingBy(RiskRecord::getRiskTypeID,
                                Collectors.maxBy(new CompareRiskRecords())
                        )));

        //Найдем для каждой сделки максимальную дату DateTimeCalc
        Map<String, Optional<Timestamp>> collect1 = rr.stream().collect(Collectors.groupingBy(RiskRecord::getBusinessProcessId,
                Collectors.mapping(RiskRecord::getDateTimeCalcGMT,
                        Collectors.maxBy(Timestamp::compareTo))
                )
        );
        List<RiskRecord> results = new ArrayList<>();
        //Находим результат

        collect.entrySet().stream().flatMap(o -> o.getValue().entrySet().stream()).forEach(o -> o.getValue().ifPresent(ro -> {
                    String businessProcessId = ro.getBusinessProcessId();
                    Timestamp dateTimeCalcGMT = ro.getDateTimeCalcGMT();
                    collect1.get(businessProcessId).ifPresent(dt -> {
                        if (dt.equals(dateTimeCalcGMT)) {
                            results.add(ro);
                        }
                    });
                }
        ));

        //.forEach(r->r.getValue().ifPresent(results::add));
        print(collect, collect1, results);
    }

    public class CompareRiskRecords implements Comparator<RiskRecord> {
        @Override
        public int compare(RiskRecord o1, RiskRecord o2) {
            Timestamp t1 = o1.getDateTimeCalcGMT();
            Timestamp t2 = o2.getDateTimeCalcGMT();

            if (t1 == null || t2 == null) {
                return 0;
            }
            if (t1.equals(t2)) {
                Timestamp u1 = o1.getUpdateDateTime();
                Timestamp u2 = o2.getUpdateDateTime();
                if (u1 == null || u2 == null) {
                    return 0;
                } else {
                    return u1.compareTo(u2);
                }
            } else {
                return t1.compareTo(t2);
            }
        }
    }
}
