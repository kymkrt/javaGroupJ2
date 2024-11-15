show databases;
show tables;

create table announcementBoard(
	idx int not null auto_increment, /*고유번호*/
	publicTitle varchar(100) not null, /*공지사항 제목*/
	publicMid varchar(30) not null, /*공지사항 작성자 아이디*/
	publicNickName varchar(30) not null, /*공지사항 작성자 닉네임*/
	publicContent text not null, /*공지사항 내용*/
	publicView int default 0, /*공지사항 조회수*/
	publicDate datetime default now(), /*공지사항 작성시간 현재기준*/
	publicFiles varchar(200), /*공지사항 첨부파일*/
	primary key(idx),
	foreign key(publicMid) references member(mid)	
);