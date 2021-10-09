#Run a Simple REST API based on playframework
FROM            centos:7
MAINTAINER      Yiyi Kang <yiyikangrachel@gmail.com>

ENV DEBIAN_FRONTEND="noninteractive"

#Prepare System
RUN	   yum --enablerepo=extras -y install epel-release
RUN	   yum -y update

#Install Java
RUN         yum install -y java-1.8.0-openjdk

#Install the Application
RUN         mkdir /share/
RUN         mv /etc/localtime /etc/localtime_bak
RUN         ln -s /usr/share/zoneinfo/America/New_York /etc/localtime
WORKDIR     /share/

ADD         target/netsuiteconnector-*-bundle.tar.gz /share/

#Start the Application
RUN     mkdir -p /app/
WORKDIR /app
CMD	[ "./start.sh" ]



