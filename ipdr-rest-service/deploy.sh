#!/bin/bash
export JRE_HOME=/dc/vol3/softwares/jre1.8.0_20
export CATALINA_HOME=/dc/vol3/softwares/apache-tomcat-7.0.55
export CATALINA_BASE=/dc/vol3/perf_view/runtimes/tomcat-stg1
path=$(find /home/utpdev -iname "*.war")
fullfile=$(basename "$path")
filename=$(basename "$path" ".war")
service=$(echo $filename | cut -d"-" -f1-3)
extension=$(echo $filename | cut -d"-" -f4)
build=$(echo $extension | cut -d"." -f3)
major=$(echo $extension | cut -d"." -f1 | sed 's/^0*//')
minor=$(echo $extension | cut -d"." -f2 | sed 's/^0*//')
previous=$((minor-1))
cp -R $fullfile /dc/vol3/perf_view/deploy/env/tmp/
unzip -q -o $fullfile -d $service-$major.$minor
cd /dc/vol3/perf_view/deploy/env/stg/
mkdir -p $1
cp -R /dc/vol3/perf_view/deploy/env/tmp/$service-$major.$minor/ /dc/vol3/perf_view/deploy/env/stg/$1/
/dc/vol3/softwares/apache-tomcat-7.0.55/bin/shutdown.sh
rm $service-$major.$previous
ln -s /dc/vol3/perf_view/deploy/env/stg/$1/$service-$major.$minor /dc/vol3/perf_view/runtimes/tomcat-stg1/webapps/
/dc/vol3/softwares/apache-tomcat-7.0.55/bin/startup.sh
