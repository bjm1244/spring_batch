#스프링 배치 프로젝트
#
~~~
	- 서비스 구조
		API server ======> Spring batch ======> Mysql
	- 서비스 환경
		- Mac
		- mysql 8.0.19
		- eclipse+spring development tool
		- spring 환경 : 각 프로젝트 pom.xml 참고
	- API server
		- java model 기반으로 객체 생성 시 xml로 보여주는 spring mvc 더비 api 서버
		- API 요청이 시간이 소요 되거난 혹은 공공데이터에서는 키를 받았음에도 인증받지 못한 키로 인식을 못하기에 만듦
	- Spring batch
		- API주소를 받아 mysql에 업로드 하는 batch 프로그램
		- App에서 jobLauncher, job 빈 주입 받음
		- RunScheduler에서 job 작동
		- RunScheduler가 작동 하기 위해 job, dataSource, context.xml 설정
		- job : Reader, Writer로 구성되어 있음.
			- Reader : Api(현재는 더미서버)서버에서 xml을 받아 Model의 VO와 매핑
			- Writer : 매핑된 데이터를 Mysql로 업로드
		- 더미데이터 : mybatis 연동, reader 자바 파일, api용 자바 파일
	- Mysql
		- Spring batch의 Writer를 통해 데이터가 업로드 되는 DB
		- Job 관련 로그
			- dataSource.xml에서 jdbc:script로 작동
				- 테이블 생성(테이블 유무에 따라)
				- 초기 세팅(몇몇 테이블에 insert하는 것)
					- DB가 존재하는데, 데이터 없을 시 오류
					- Job log가 0부터 시작 할 시 이후에 Job log에 데이터 들어가지 않고, 실행이 되지않음. 
					- 실패한 것만 남을시 오류
		- record 테이블
			- job을 통해 데이터가 업로드 되는 테이블
~~~