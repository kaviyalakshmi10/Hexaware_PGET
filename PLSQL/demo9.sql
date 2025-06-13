create or replace procedure calc_bonus (
    sal   in  number,
    bon   out number,
    tsal  out number
)
as
begin
    if sal <= 5000 then
        bon := sal * 0.05;
    else
        bon := sal * 0.10;
    end if;

    tsal := sal + bon;
end;
/
