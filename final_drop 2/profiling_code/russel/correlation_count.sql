select zip, sum(CondomProviders) as condom_providers, sum(ChildCareViolations) as childcare_violations
from (
  select condom_availability.zip zip, count(*) CondomProviders, 0 ChildCareViolations 
  from condom_availability 
  group by zip

  union

  select childcare_violations.zip, 0, count(*) 
  from childcare_violations
   group by zip
) CountsTable
group by CountsTable.zip order by sum(ChildCareViolations) desc;