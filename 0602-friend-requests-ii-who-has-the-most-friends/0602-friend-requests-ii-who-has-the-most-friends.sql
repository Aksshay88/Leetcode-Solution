SELECT frnd_id as id, count(*) as num 
FROM
(SELECT requester_id as frnd_id
FROM RequestAccepted 
UNION ALL
SELECT accepter_id as frnd_id
FROM RequestAccepted) as t
GROUP BY frnd_id
ORDER BY num DESC
limit 1