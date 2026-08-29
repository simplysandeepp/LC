SELECT activity_date AS day,
       COUNT(DISTINCT user_id) AS active_users
FROM Activity
WHERE DATE_SUB('2019-07-27', INTERVAL 30 DAY) < activity_date
  AND activity_date <= '2019-07-27'
GROUP BY activity_date;