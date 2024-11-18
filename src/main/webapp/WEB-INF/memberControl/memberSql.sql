show databases;

select databasse();

show tables;

desc member;

drop table member;


create table member (
	idx int not null auto_increment, /*회원 고유 번호*/
	/*()숫자 넘으면 오류*/
	mid varchar(30) not null, /*회원 아이디(중복불허) 유니크키*/
	pwd varchar(100) not null, /*회원 비밀번호(SHA256/512 암호화처리 여기선256 보통 256쓴다) 암호화할때는 길이 많이 줘야함*/
	nickName varchar(30) not null, /*회원 닉네임(중복불허/수정가능)*/
	name varchar(30) not null, /*회원 성명(중복허용) 가변길이*/
	telMain varchar(15) not null,  /*메인전화번호 : 010-1234-5678 */
	telSub varchar(15) default '0',  /*서브전화번호 : 010-1234-5678 */
	address varchar(180), /*주소(우편번호:다음 API 활용)*/
	email varchar(60) not null, /*이메일(아이디/비밀번호 분실시에 사용) - 형식체크(유효성검사)필수 */
	content text, /*자기소개*/
	photo varchar(100) default 'noimage.jpg', /*회원사진*/	
	advertiseCheck char(2) not null default 'O', /*광고 동의 여부*/
	userInfo char(3) default '공개', /*회원의 정보 공개 유무(공개/비공개) 고정길이 실무에선 ok/no같은 방식 많이 씀*/
	userType char(6) not null default '개인',/*사업자 개인 선택 리드온리 처리*/
	/*사업자일시 추가 부분*/
	fax varchar(15) default '0',  /*팩스번호 : 010-1234-5678 */
	companyName varchar(100), /*회사명 사업자 일때만*/
	BSNum varchar(15) default '0', /*사업자 번호 없으면 0*/
	/*관리자 처리 부분*/
	userDel char(2) default 'NO', /*회원 탈퇴 신청 여부(NO:현재 활동중, OK:탈퇴신청중)*/
	level int default 1, /*회원 등급(0:관리자, 1:준회원, 2:정회원, 3,:우수회원 (4:운영자), 99:탈퇴신청회원)*/
	point int default 100, /* 회원 누적 포인트*/
	visitCnt int default 0, /*총 방문 횟수*/
	todayCnt int default 0, /*오늘 방문 카운트*/
	startDate datetime default now(), /*최초 가입일*/
	lastDate datetime default now(), /*마지막 접속일(탈퇴시는 탈퇴한 날짜)*/
	memoryMid varchar(30) not null, /*저장용 아이디*/
	primary key(idx), /*이렇게 미리 해두면 좋다*/
	unique key(mid),
	unique key(memoryMid)
);
insert into member values(default,'admin','1234','관리자','01055551111', default,'충북 청주시 그린컴퓨터아트 학원','asdf@asdf.com','관리자입니다'
	,default,default,default,'관리자',0,'관리',default,default,0,default,default,default,default,default,'admin'
);

select * from member;
