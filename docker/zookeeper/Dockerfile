FROM debian:buster

RUN DEBIAN_FRONTEND=noninteractive apt-get update
RUN DEBIAN_FRONTEND=noninteractive apt-get -y install curl
RUN curl -Lo /tmp/java_11.deb https://cdn.azul.com/zulu/bin/zulu11.39.15-ca-jdk11.0.7-linux_amd64.deb
RUN dpkg -i /tmp/java_11.deb; apt-get -yf install \
    && rm /tmp/java_11.deb

RUN java -version

RUN DEBIAN_FRONTEND=noninteractive apt-get -y install jq procps
RUN APACHE_MIRROR=$(curl -s 'https://www.apache.org/dyn/closer.cgi?as_json=1' | jq --raw-output '.preferred') \
    && curl -o /opt/zookeeper.tgz "${APACHE_MIRROR}/zookeeper/zookeeper-3.5.8/apache-zookeeper-3.5.8-bin.tar.gz"

RUN cd /opt \
    && tar xzf zookeeper.tgz \
    && mv apache-zookeeper* zookeeper \
    && rm zookeeper.tgz

RUN DEBIAN_FRONTEND=noninteractive apt-get -y install dos2unix procps
RUN mkdir -p /var/zookeeper
COPY zoo.cfg /opt/zookeeper/conf/zoo.cfg
COPY startup.sh /opt/zookeeper-startup.sh
RUN dos2unix /opt/zookeeper-startup.sh /opt/zookeeper/conf/zoo.cfg


CMD /opt/zookeeper-startup.sh $SERVER_ID