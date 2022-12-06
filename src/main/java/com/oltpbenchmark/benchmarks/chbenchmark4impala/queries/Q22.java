/*
 * Copyright 2020 by OLTPBenchmark Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.oltpbenchmark.benchmarks.chbenchmark4impala.queries;

import com.oltpbenchmark.api.SQLStmt;

import static com.oltpbenchmark.benchmarks.chbenchmark4impala.TableNames.customer;
import static com.oltpbenchmark.benchmarks.chbenchmark4impala.TableNames.oorder;

public class Q22 extends GenericQuery {

    public final SQLStmt query_stmt = new SQLStmt(
            "SELECT substring(c_state,1,1) AS country, "
                    + "count(*) AS numcust, "
                    + "sum(c_balance) AS totacctbal "
                    + "FROM " +customer() + " "
                    + "WHERE substring(c_phone, 1, 1) IN ('1', "
                    + "'2', "
                    + "'3', "
                    + "'4', "
                    + "'5', "
                    + "'6', "
                    + "'7') "
                    + "AND c_balance > "
                    + "(SELECT avg(c_balance) "
                    + "FROM " +customer() + " "
                    + "WHERE c_balance > 0.00 "
                    + "AND substring(c_phone, 1, 1) IN ('1', "
                    + "'2', "
                    + "'3', "
                    + "'4', "
                    + "'5', "
                    + "'6', "
                    + "'7')) "
                    + "AND NOT EXISTS "
                    + "(SELECT * "
                    + "FROM " +oorder() + " "
                    + "WHERE o_c_id = c_id "
                    + "AND o_w_id = c_w_id "
                    + "AND o_d_id = c_d_id) "
                    + "GROUP BY substring(c_state, 1, 1) "
                    + "ORDER BY substring(c_state,1,1)"
    );

    protected SQLStmt get_query() {
        return query_stmt;
    }

    public static void main(String[] args) {
        System.out.println(new Q1().query_stmt.getSQL());
        System.out.println(new Q2().query_stmt.getSQL());
        System.out.println(new Q3().query_stmt.getSQL());
        System.out.println(new Q4().query_stmt.getSQL());
        System.out.println(new Q5().query_stmt.getSQL());
        System.out.println(new Q6().query_stmt.getSQL());
        System.out.println(new Q7().query_stmt.getSQL());
        System.out.println(new Q8().query_stmt.getSQL());
        System.out.println(new Q9().query_stmt.getSQL());
        System.out.println(new Q10().query_stmt.getSQL());
        System.out.println(new Q11().query_stmt.getSQL());
        System.out.println(new Q12().query_stmt.getSQL());
        System.out.println(new Q13().query_stmt.getSQL());
        System.out.println(new Q14().query_stmt.getSQL());
//        System.out.println(new Q15().query_stmt.getSQL());
        System.out.println(new Q16().query_stmt.getSQL());
        System.out.println(new Q17().query_stmt.getSQL());
        System.out.println(new Q18().query_stmt.getSQL());
        System.out.println(new Q19().query_stmt.getSQL());
        System.out.println(new Q20().query_stmt.getSQL());
        System.out.println(new Q21().query_stmt.getSQL());
        System.out.println(new Q22().query_stmt.getSQL());
    }
}
