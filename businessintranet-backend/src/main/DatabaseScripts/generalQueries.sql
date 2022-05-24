select * from employee;
select * from roles;
select * from employee_roles;

select * from calendar_event_invited_employees;

select * from calendar_event;

insert into calendar_event(id,title,start,end,color_name,primary_color,secondary_color)
values(1,'event title','2022-05-14','2022-05-23','Blue','#0000CC','#CCE5FF');

insert into calendar_event(id,title,start,end,color_name,primary_color,secondary_color)
values(2,'PAAAG','2022-05-17','2022-05-21','Red','#FF0000','#FFE5E5');

select * from calendar_event_color;

insert into calendar_event_color(id,color_name,primary_color,secondary_color)
values(1,'Red','#FF0000','#FFE5E5'),(2,'Blue','#0000CC','#CCE5FF'),(3,'Green','#009900','#E5FFCC'),
(4,'Purple','#9933FF','#E5CCFF')