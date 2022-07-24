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


INSERT INTO users (user_id, user_name, user_gym,manager_yn)
VALUES('1237', '김철수', '광주남구',0);

update users
set user_birthdate='1995-08-20',user_height='80', user_weight='177',user_joindate='2021-10-14',user_expire_date='2022-10-14'
where user_id = '1234';
