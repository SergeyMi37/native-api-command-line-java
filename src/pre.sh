#!/bin/bash

echo "Building..."
cd /opt/irisapp
javac -classpath /usr/irissys/dev/java/lib/1.8/intersystems-jdbc-3.7.1.jar -d . src/rcc.java
echo "   *** ready to use ***"