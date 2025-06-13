create or replace procedure calculate_bonus(p_salary in number) is
  v_bonus number;
  v_total_sal number;
begin
  v_bonus := p_salary * 0.10;  -- 10% bonus
  v_total_salary := p_salary + v_bonus;

  dbms_output.put_line('bonus amount: ' || v_bonus);
  dbms_output.put_line('total salary: ' || v_total_sal);
end;
/
