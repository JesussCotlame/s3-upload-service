run-app:
	./mvnw spring-boot:run

run-app-localstack:
	./mvnw spring-boot:run -Dspring-boot.run.profiles=localstack

create-bucket:
	AWS_ACCESS_KEY_ID=test AWS_SECRET_ACCESS_KEY=test aws --region us-east-1 --endpoint-url=http://localhost:4566 s3 mb s3://my-test-bucket || true

list-objects:
	AWS_ACCESS_KEY_ID=test AWS_SECRET_ACCESS_KEY=test aws --region us-east-1 --endpoint-url=http://localhost:4566 s3 ls s3://my-test-bucket

start-localstack:
	$(MAKE) -C docker start-localstack

stop-localstack:
	$(MAKE) -C docker stop-localstack