#!/usr/bin/env bash
find . -name "*.java" > sources.txt
javac -sourcepath . @sources.txt
java mnaidoo.simulator.Simulator scenario.txt
