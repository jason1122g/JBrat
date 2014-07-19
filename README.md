## JBrat-2 [![Build Status](https://travis-ci.org/jason1122g/JBrat.svg?branch=JBrat2)](https://travis-ci.org/jason1122g/JBrat)
- jbrat-core      : include classes for jbrat programming
- jbrat-generator : include the generator of components and project

### Install
1. Download the zip and extract
2. Change directory into it
3. Execute command ``` gradlew distZip ```
4. Change directory into jbrat-generator/build/distributions
5. Extract the zip file and then copy them to somewhere else
6. Add the path of 'jbrat-x.x.x/bin' folder  into environment variable

### Init a project
- Execute command ``` jbrat init [project name] ```

### Init a view
- Execute command ``` jbrat g view [view name] ```