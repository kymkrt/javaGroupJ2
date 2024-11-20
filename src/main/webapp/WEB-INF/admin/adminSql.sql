show tables;

show events;

SET GLOBAL event_scheduler = ON; /*이벤트 스케줄러 활성화*/

/*30일마다 탈퇴 계정 지우기*/
CREATE EVENT IF NOT EXISTS delete_withdrawn_users
ON SCHEDULE EVERY 1 DAY
STARTS CURRENT_TIMESTAMP
DO
BEGIN
    DELETE FROM member
    WHERE mid = 'withDraw'
      AND userDel = 'OK'
      AND lastDate < NOW() - INTERVAL 30 DAY;
END;

/*성공한 이벤트 코드*/
CREATE EVENT delete_withdrawn_members
ON SCHEDULE EVERY 1 DAY
DO
BEGIN
  DELETE FROM member
  WHERE mid = 'withDraw'
  AND userDel = 'OK'
  AND lastDate < DATE_SUB(NOW(), INTERVAL 30 DAY);
END;

/*이벤트 스케줄러 상태 확인 on이 켜진것*/
SHOW VARIABLES LIKE 'event_scheduler';

/*이벤트 권환 확인*/
SHOW GRANTS FOR CURRENT_USER;

SHOW VARIABLES LIKE 'log_error';