select array_agg(distinct borough) as borough from childcare_violations;
select array_agg(distinct zip) as zip from childcare_violations;
select array_agg(distinct maxcap) as maxcap from childcare_violations;
select array_agg(distinct violationrate) as violationrate from childcare_violations;
select array_agg(distinct avgviolationrate) as avgviolationrate from childcare_violations;
select array_agg(distinct hhviolationrate) as hhviolationrate from childcare_violations;
select array_agg(distinct avghhviolationrate) as avghhviolationrate from childcare_violations;
select array_agg(distinct critviolationrate) as critviolationrate from childcare_violations;
select array_agg(distinct avgcritviolationrate) as avgcritviolationrate from childcare_violations;
select array_agg(distinct violationcategory) as violationcategory from childcare_violations;
select array_agg(distinct violationstatus) as violationstatus from childcare_violations;
select array_agg(distinct highrisk) as highrisk from childcare_violations;