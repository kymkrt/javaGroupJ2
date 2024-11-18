show tables;

desc estimate;

create table estimate(
	idx int not null auto_increment, /*게시글의 고유번호*/
	mid varchar(30) not null, /*게시글 올린이 아이디 닉네임은 변경이 가능하기 때문에 아이디가 있어야 한다 구조가 다른 테이블과 같아야 한다*/
	nickName varchar(30) not null, /*게시글 올린이 닉네임*/
	title varchar(100) not null, /*게시글 제목*/
	content text not null, /* 글 내용*/
	hostIp varchar(40) not null, /*글 올린이 IP*/
	wDate datetime default now(), /*글올린 날짜*/
  file varchar(200) default '없음', /*업로드 파일*/

	primary key(idx),
	foreign key(mid) references member(memoryMid)
);