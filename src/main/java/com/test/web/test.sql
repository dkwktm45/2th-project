select * from users

select * from access
CREATE TABLE users
(
    user_id             VARCHAR(30)      NOT NULL, 
    user_name           VARCHAR(20)       NULL, 
    user_phone          VARCHAR(20)      NULL, 
    user_birthdate      DATE              NULL, 
    user_height         int(12)     NULL, 
    user_weight         int(12)     NULL, 
    user_gym            VARCHAR(150)     NULL, 
    user_joindate       DATE              NULL, 
    user_expire_date    DATE              NULL, 
    manager_yn          VARCHAR(1)       NULL, 
    ad_comment          VARCHAR(2000)    NULL,
    video_yn varchar(1) null,
    CONSTRAINT PK_users PRIMARY KEY (user_id)
)
SELECT * FROM user_exercises where user_id= '4073' order by  asc LIMIT 1
CREATE TABLE user_exercises
(
    ex_seq           int(100)      NOT NULL  AUTO_INCREMENT, 
    user_id          VARCHAR(20)       NULL, 
    ex_name          VARCHAR(20)      NULL,
    ex_kinds          VARCHAR(20)      NULL, 
    user_set          VARCHAR(20)      NULL,
    ex_count          VARCHAR(20)      NULL,
    ex_date date null,
    cnt varchar(20) null ,
    CONSTRAINT FK_user_exercises PRIMARY KEY (ex_seq),
    FOREIGN KEY (user_id) REFERENCES users (user_id)
)
insert into user_exercises(ex_seq , user_id , ex_name, ex_kinds , user_set , ex_count , ex_date , cnt) 
value(default ,'4073','체스트 플라이','가슴', '4','12','2021-11-05','12')

insert into user_exercises(ex_seq , user_id , ex_name, ex_kinds , user_set , ex_count , ex_date , cnt)
value('1','4073','덤벨 숄더프레스', '어깨' , '4' , '12', now() , '12');
select * from user_exercises
CREATE TABLE exercise_videos
(
    video_seq           int(100)      NOT NULL  AUTO_INCREMENT, 
    ex_seq           int(100),
    file_name          VARCHAR(100)       NULL, 
    user_id          VARCHAR(20)      NULL,
    video_date date null,
    CONSTRAINT FK_exercise_videos PRIMARY KEY (video_seq),
    FOREIGN KEY (user_id) REFERENCES users (user_id),
    FOREIGN KEY (ex_seq) REFERENCES user_exercises (ex_seq)
)
insert into exercise_videos(video_seq , ex_seq , file_name, user_id , video_date)
value('1','1','덤벨 숄더 프레스', '4073' ,now());
update exercise_videos set file_name = '덤벨 숄더 프레스' where user_id = '4073'

select * from exercise_videos;
select * from user_exercises;

delete from user_exercises where ex_seq = 1;
delete from user_exercises where ex_seq = 2;
delete from user_exercises where ex_seq = 3;
delete from user_exercises where ex_seq = 8;
delete from user_exercises where ex_seq = 14;
delete from user_exercises where ex_seq = 15;
delete from user_exercises where ex_seq = 16;
delete from user_exercises where ex_seq = 17;
delete from user_exercises where ex_seq = 18;
delete from exercise_videos where video_seq = 18;
delete from user_exercises where ex_seq = 10;


update deep_postures set ex_count = '오른쪽1' where ex_seq = 4
update deep_postures set pose_result = '왼쪽1', ai_comment = 'Rase left!' where deep_seq = 4

CREATE TABLE deep_postures
(
    deep_seq          int(100) null AUTO_INCREMENT,
    video_seq         int(100) null, 
    video_time          int(100)       NULL, 
    pose_result          VARCHAR(100)     NULL,
    ai_comment varchar(100) null,
    CONSTRAINT FK_deep_videos PRIMARY KEY (deep_seq),
    FOREIGN KEY (video_seq) REFERENCES exercise_videos (video_seq)
)
insert into deep_postures(deep_seq , video_seq , pose_result , ai_comment)
	    value (default ,(select video_seq from exercise_videos where ex_seq = 3),'test', 'test') 

select * from deep_postures
select * from exercise_videos
CREATE TABLE access
(
    user_id          VARCHAR(20)       NULL, 
    ex_day          DATE      NULL, 
    ex_start_time    time              NULL, 
    ex_end_time      time     NULL,
    FOREIGN KEY (user_id) REFERENCES users (user_id)
)

insert into users(user_id , user_gym , manager_yn) values('5678','광주남구','1') 



drop table users

drop table exercise_videos

drop table user_exercises

drop table deep_postures

drop table access


alter table users add video_yn varchar(1) not null default '0'; 

select user_id , ex_kinds
      from user_exercises
      where user_id=1234
      deep_postures
select * from user_exercises
select * from deep_postures
select * from exercise_videos



insert into deep_postures(video_seq,pose_result,ai_comment)
value(2 ,'자세교정3', '팔을 내려주세요!!')

update user_exercises 
set ex_kinds ='어깨'
where ex_kinds ='가슴'

update deep_postures 
set pose_result ='자세교정3'
where pose_result = '??'


update user_exercises 
set user_set ='4', ex_count = '12'
where user_id = '1234'


select *
from deep_postures



drop table user_exercises

drop table exercise_videos

update users
set user_birthdate='1995-08-20',user_height='80', user_weight='177',user_joindate='2021-10-14',user_expire_date='2022-10-14'
where  user_id = '1234';
insert



INSERT INTO users (user_id, user_name, user_gym ,manager_yn)
VALUES('1234', '이진영', '광주남구');


insert into user_exercises(user_id , ex_name, ex_kinds)
values('1234','체스트프레스','팔')

insert into user_exercises(user_id , ex_name, ex_kinds)
values('1234','벤치프레스','팔')

select * from
where user_id ='1234'
and


select * from users

CREATE TABLE users
(
    user_id             VARCHAR(30)      NOT NULL, 
    user_name           VARCHAR(20)       NULL, 
    user_phone          VARCHAR(20)      NULL, 
    user_birthdate      DATE              NULL, 
    user_height         int(12)     NULL, 
    user_weight         int(12)     NULL, 
    user_gym            VARCHAR(150)     NULL, 
    user_joindate       DATE              NULL, 
    user_expire_date    DATE              NULL, 
    manager_yn          VARCHAR(1)       NULL, 
    ad_comment          VARCHAR(2000)    NULL, 
    CONSTRAINT PK_users PRIMARY KEY (user_id)
)

CREATE TABLE user_exercises
(
    ex_seq           int(100)      NOT NULL  AUTO_INCREMENT, 
    user_id          VARCHAR(20)       NULL, 
    ex_name          VARCHAR(20)      NULL, 
    ex_start_time    DATE              NULL, 
    ex_end_time      DATE     NULL, 
    ex_count         int(30)     NULL, 
    CONSTRAINT FK_user_exercises PRIMARY KEY (ex_seq),
    FOREIGN KEY (user_id) REFERENCES users (user_id)
)

select *
from access
SELECT user_id ,video_date
      FROM exercise_videos
drop table access
drop table user_exercises

update users
set ex_start_time = '2021-10-15 06:01:00',ex_end_time='2021-10-15 07:01:00'
where user_id = '1234';

update users
set user_weight = 70
where user_id = '1234';

SELECT TIMESTAMPDIFF(minute,'2021-10-15 06:01:00','2021-10-15 07:01:00')

SELECT TIMESTAMPDIFF(minute, ex_start_time, ex_end_time) AS time_diff 
from users
where user_id = '1234';

select * from access

select a.ex_day , u.user_weight
from access a , users u
where a.user_id = '1234' and u.user_id = '1234';

alter table users modify ex_start_time DATETIME;
alter table users modify ex_end_time DATETIME;

alter table users add ex_start_time DATETIME NULL;
alter table users add ex_end_time DATETIME NULL; 

alter table users add day VARCHAR(20) NULL;
alter table users add timediff VARCHAR(20) NULL; 

INSERT INTO users (user_id, user_name, user_gym,manager_yn)
VALUES('1234', '노유종', '광주남구','1');

select day(ex_start_time,ex_end_time) as day
from users
where user_id = '1234'

select day(ex_start_time) as day , TIMESTAMPDIFF(minute, ex_start_time , ex_end_time) as timediff
       from users
       where user_id = '1234'
       
select * from users
insert into users(user_id,user_phone, user_name,user_gym,user_expire_date,user_birthdate,manager_yn)
       values (right('010-1234-5678',4),'010-1234-5678','이소연','광주남구', date_add(DATE_FORMAT(now(),'%Y-%m-%d'),INTERVAL 3 MONTH) ,'1995-08-20',0)
       
INSERT INTO access (user_id, ex_day, ex_start_time , ex_end_time)
VALUES('4073', '2021-11-05', '07:00','09:00');

select * from access
delete from access where ex_day = '2021-11-06' 

VALUES('1234', '2021-10-23', '07:00','09:00');

select * from user_exercises
where user_id= '1234'
and ex_date = '2021-11-03'

       
select ex_day , TIMESTAMPDIFF(minute, ex_start_time , ex_end_time) as timediff
       from access
       where user_id = '1234'  
       
update users set user_weight = '60'
where user_id = '4073'

select * from users

update users set day='10', timediff='10' where user_id='1234';