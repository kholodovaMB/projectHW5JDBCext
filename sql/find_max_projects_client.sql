select name, count(*) AS project_count
from project
join client on client.ID = CLIENT_ID
group by client_id
HAVING COUNT(*) = (SELECT MAX(project_count)
  FROM (
    SELECT COUNT(*) AS project_count
    FROM project
    GROUP BY CLIENT_ID
  ) project);