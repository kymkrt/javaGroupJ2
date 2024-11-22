CREATE TABLE `messagechat` (
	idx INT(11) NOT NULL AUTO_INCREMENT, /*메세지 고유번호*/
	sender VARCHAR(500) NOT NULL DEFAULT '0', /*보낸사람 닉네임*/
	receiver VARCHAR(500) NOT NULL DEFAULT '0', /*받은 사람 닉네임*/
	content VARCHAR(1000) NOT NULL DEFAULT '0', /*내용*/
	wDate DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP, /*보낸시간*/
	read int NOT NULL DEFAULT 0, /*보낸시간*/
	PRIMARY KEY (`idx`)
);