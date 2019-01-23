CREATE DEFINER=`root`@`localhost` FUNCTION `average_age_per_position`(
	position_par varchar(15)
) RETURNS decimal(9,2)
    DETERMINISTIC
BEGIN
  DECLARE avgAge Integer; 
	select avg(age)
	into avgAge
	from details
	where position = position_par;
 RETURN avgAge;

END