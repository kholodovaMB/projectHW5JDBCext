select project.ID, sum(worker.SALARY)*DATEDIFF(MONTH, START_DATE, FINISH_DATE) as PRICE
from project
join project_worker on project.ID=project_worker.PROJECT_ID
join worker on project_worker.WORKER_ID = worker.ID GROUP BY project.ID;