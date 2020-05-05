#Spring Batch
#
~~~
- Job의 구성 
		- Job : 배치 작업이다. 혹은 Flow 
			- 최소 하나의 Step을 가져야 하며 엄청나게 복잡한 Job이 아닌 이상 2~10개의 Step 권장
			- 만약 Step 개수가 10개 이상이면 일반적인 코드 리팩토링처럼 여러 개의 Job으로 쪼개서 하나의 Job에 너무 많은 책임들(Responsibilities)이 몰리게 하지 말자
				- 뭔 말인지 잘 모르겠음. : 내 생각으로는 여러개 쪼개서 한 job에서 여러개의 메쏘드를 실행시키지 마라 이런 것 같음.
		- Step
			- 읽기->가공하기->쓰기의 묶음.
			- Chunck processing이라고도 함.
		- Chunck processing 예시
		예제{
			List items = new Arraylist();
			for(int i = 0; i < commitInterval; i++){
 			   	Object item = itemReader.read()
				Object processedItem = itemProcessor.process(item);
    				items.add(processedItem);
    			}
			itemWriter.write(items);
		}
		- ItemReader
			- 데이터 읽기를 담당. 정확히는 인터페이서이며 T(템플릿) read()메소드를 가짐
		- ItemProcessor
			- ItemProcessor는 ItemReader에게서 Object를 넘겨받아 원하는 방식으로 가공 후에 ItemWriter에게 넘겨주는 역할을 하며, 한 번에 하나의 아이템을 처리
		- ItemWriter
			- ItemReader 혹은 ItemProcessor가 ItemWriter로 데이터를 넘겨주면 리스트에 차곡차곡 쌓아놓는다. 
			- 이때 commit-interval 프로퍼티의 정의된 개수만큼 데이터가 모이면 write 메소드를 실행하게 된다. 
			- commit-interval은 Step에 설정할 수 있다. (정확히는 Step 안에 Chunk에)
		- ItemReader와 마찬가지로 스프링 배치에서 제공해주는 자주 쓰이는 ItemWriter 구현체
			- CompositeItemWriter 
			- FlatFileItemWriter
			- HibernateItemWriter
			- JdbcBatchItemWriter
			- JsonFileItemWriter
			- MongoItemWriter
		- tasklet
			- chunk (reader + processor + writer) 를 사용하면 읽기 -> 가공하기 -> 쓰기의 반복인데
			- chunk 없이 한 번만 실행하도록 하는 것
~~~