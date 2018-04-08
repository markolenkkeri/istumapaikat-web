# Istumapaikat-web
Tool for randomizing seat locations. Same as istumapaikat, but in webapp format.

## Installation
Clone this repository. Run `./gradlew bootRun` or `gradlew.bat bootRun` or install Gradle and Grails with http://sdkman.io .

## Usage
Call http://localhost:8080/action/randomize

## Contents
Grails application (Grails 3.3.4) with in memory database, JSON marshallers and CSV readers. See `grails-app/controllers` and `grails-app/services` for core functionalities. Rest in `grails-app/init` and `grails-app/domain`. 
