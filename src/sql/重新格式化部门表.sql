/*
部门表 Department：

+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| id            | int     |
| revenue       | int     |
| month         | varchar |
+---------------+---------+
(id, month) 是表的联合主键。
这个表格有关于每个部门每月收入的信息。
月份（month）可以取下列值 ["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"]。
 

编写一个 SQL 查询来重新格式化表，使得新的表中有一个部门 id 列和一些对应 每个月 的收入（revenue）列。

查询结果格式如下面的示例所示：

Department 表：
+------+---------+-------+
| id   | revenue | month |
+------+---------+-------+
| 1    | 8000    | Jan   |
| 2    | 9000    | Jan   |
| 3    | 10000   | Feb   |
| 1    | 7000    | Feb   |
| 1    | 6000    | Mar   |
+------+---------+-------+

查询得到的结果表：
+------+-------------+-------------+-------------+-----+-------------+
| id   | Jan_Revenue | Feb_Revenue | Mar_Revenue | ... | Dec_Revenue |
+------+-------------+-------------+-------------+-----+-------------+
| 1    | 8000        | 7000        | 6000        | ... | null        |
| 2    | 9000        | null        | null        | ... | null        |
| 3    | null        | 10000       | null        | ... | null        |
+------+-------------+-------------+-------------+-----+-------------+

注意，结果表有 13 列 (1个部门 id 列 + 12个月份的收入列)。

*/
SELECT
    id,
    sum( CASE MONTH WHEN 'Jan' THEN revenue END ) AS Jan_Revenue,
    sum( CASE MONTH WHEN 'Feb' THEN revenue END ) AS Feb_Revenue,
    sum( CASE MONTH WHEN 'Mar' THEN revenue END ) AS Mar_Revenue,
    sum( CASE MONTH WHEN 'Apr' THEN revenue END ) AS Apr_Revenue,
    sum( CASE MONTH WHEN 'May' THEN revenue END ) AS May_Revenue,
    sum( CASE MONTH WHEN 'Jun' THEN revenue END ) AS Jun_Revenue,
    sum( CASE MONTH WHEN 'Jul' THEN revenue END ) AS Jul_Revenue,
    sum( CASE MONTH WHEN 'Aug' THEN revenue END ) AS Aug_Revenue,
    sum( CASE MONTH WHEN 'Sep' THEN revenue END ) AS Sep_Revenue,
    sum( CASE MONTH WHEN 'Oct' THEN revenue END ) AS Oct_Revenue,
    sum( CASE MONTH WHEN 'Nov' THEN revenue END ) AS Nov_Revenue,
    sum( CASE MONTH WHEN 'Dec' THEN revenue END ) AS Dec_Revenue
FROM
    Department
GROUP BY
    id