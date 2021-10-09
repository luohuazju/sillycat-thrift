#!/bin/sh

PID=$(ps -ef | grep "lib/netsuiteconnector" | grep -v grep | awk '{ print $2 }')

if test -n "${PID}"; then
	sudo kill -9 ${PID};
fi

nohup java -Djava.net.preferIPv4Stack=true \
	 -XX:MaxMetaspaceSize=256M -XX:+HeapDumpOnOutOfMemoryError \
	 -XX:HeapDumpPath="/tmp/dump_oom.hprof" \
	 -Dspring.config.location=file:./conf/application.yaml \
	 -Dlogging.config=file:./conf/log4j2.xml \
	 -jar ./lib/netsuiteconnector-*.jar > logs/netsuiteconnector.log 2>&1 &