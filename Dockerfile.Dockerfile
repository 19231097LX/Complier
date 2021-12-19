FROM openjdk:15
COPY . /app/
WORKDIR /app/
RUN javac -cp src:src/antlr-4.9.2-complete.jar src/Main.java
WORKDIR /app/src/