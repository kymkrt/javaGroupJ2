show tables;

desc marketingBoard;

create table marketingBoard(
	idx int not null auto_increment, /*게시글의 고유번호*/
	mid varchar(30) not null, /*게시글 올린이 아이디 닉네임은 변경이 가능하기 때문에 아이디가 있어야 한다 구조가 다른 테이블과 같아야 한다*/
	nickName varchar(30) not null, /*게시글 올린이 닉네임*/
	title varchar(100) not null, /*게시글 제목*/
	part ENUM('신품종','개량','수입','기타') NOT NULL DEFAULT '기타',
	content text not null, /* 글 내용*/
	hostIp varchar(40) not null, /*글 올린이 IP*/
	openSw char(3) default '공개', /*공개글 유무(공개, 비공개) 디폴트를 라이도 버튼으로 처리해도 됨*/
  viewCnt int default 0, /*글 조회수 누적 = 업데이트*/
	wDate datetime default now(), /*글올린 날짜*/
	claim char(2) default 'NO', /*신고글 유무(신고당한글 : OK, 정상글:NO)*/
  file varchar(200) default '없음', /*업로드 파일*/
	primary key(idx),
	foreign key(mid) references member(memoryMid)
);

create table marketingReply (
	idx int not null auto_increment, /*마케팅게시판 댓글의 고유번호*/
	replyIdx int not null, /*게시판글과 연결*/
	parentReplyIdx int default null,/*null이면 댓글 숫자면 대댓글*/
	level int not null default 0,/*댓글깊이 기본 댓글0 대댓글 1부터*/
	mid varchar(30) not null, /*댓글 작성자 */
	nickName varchar(30) not null,
	content text not null,
	primary key(idx),
	foreign key(replyIdx) references marketingBoard(idx) on update cascade ON DELETE CASCADE,
	foreign key(parentReplyIdx) references marketingReply(idx) on update cascade ON DELETE CASCADE
);