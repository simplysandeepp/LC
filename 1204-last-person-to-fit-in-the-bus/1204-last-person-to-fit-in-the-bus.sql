SELECT T.person_name
FROM (
    SELECT *,
        SUM(weight) OVER (ORDER BY turn ASC) AS running_total
    FROM Queue
) T
WHERE T.running_total <= 1000
ORDER BY T.turn DESC
LIMIT 1;