FROM debian:buster

RUN DEBIAN_FRONTEND=noninteractive apt-get update
RUN DEBIAN_FRONTEND=noninteractive apt-get -y install curl
RUN curl -Lo /tmp/java_11.deb https://cdn.azul.com/zulu/bin/zulu11.39.15-ca-jdk11.0.7-linux_amd64.deb
RUN dpkg -i /tmp/java_11.deb; apt-get -yf install \
    && rm /tmp/java_11.deb

RUN java -version

RUN DEBIAN_FRONTEND=noninteractive apt-get -y install jq
RUN APACHE_MIRROR=$(curl -s 'https://www.apache.org/dyn/closer.cgi?as_json=1' | jq --raw-output '.preferred') \
    && curl -o /opt/kafka.tgz "${APACHE_MIRROR}/kafka/2.5.0/kafka_2.12-2.5.0.tgz"

RUN cd /opt \
    && tar xzf kafka.tgz \
    && mv kafka_* kafka \
    && rm kafka.tgz

RUN DEBIAN_FRONTEND=noninteractive apt-get -y install dos2unix
COPY server.properties /opt/kafka/config/server.properties
COPY startup.sh /opt/kafka-startup.sh
RUN dos2unix /opt/kafka-startup.sh
RUN mkdir -p /var/kafka/data

CMD /opt/kafka-startup.sh $BROKER_ID