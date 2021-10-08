FROM openjdk:15
COPY ./ /app/
WORKDIR /app/
RUN javac -cp src/ src/Test.java -d ./