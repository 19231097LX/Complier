FROM openjdk:15
COPY . /app/
WORKDIR /app/
RUN javac -cp src:src/antlr/antlr-4.9.2-complete.jar -d dst `cat sources.txt`
WORKDIR /app/dst/