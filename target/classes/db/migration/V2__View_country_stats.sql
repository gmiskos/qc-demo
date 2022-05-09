DROP VIEW IF EXISTS country_stats_view;

CREATE VIEW country_stats_view AS
    SELECT
    cr.country_id,
    cs.year,
    cs.population,
    cs.gdp,
    cr.name as country_name,
    r.name as region_name,
    c.name as continent_name
FROM
country_stats cs
left join countries cr on cr.country_id = cs.country_id
left join regions r on r.region_id = cr.region_id
left join continents c on c.continent_id = r.continent_id