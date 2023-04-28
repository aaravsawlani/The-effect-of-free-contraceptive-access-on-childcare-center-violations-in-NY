SELECT DISTINCT partner_type AS distinct_value FROM condom_availability
UNION ALL
SELECT DISTINCT borough FROM condom_availability
UNION ALL
SELECT DISTINCT zip FROM condom_availability
UNION ALL
SELECT DISTINCT male_c FROM condom_availability
UNION ALL
SELECT DISTINCT female_c FROM condom_availability
UNION ALL
SELECT DISTINCT lube FROM condom_availability;