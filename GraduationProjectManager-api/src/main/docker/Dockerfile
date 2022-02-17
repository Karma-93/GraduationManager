FROM java:8
VOLUME /tmp
#将复制指定的    .jar为容器中的job.jar，相当于拷贝到容器中取了个别名
ADD *.jar app.jar
RUN bash -c 'touch /app.jar'
#暴露容器的端口
EXPOSE 8082
ENTRYPOINT [ "java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar" ]