## JBrat-2 [![Build Status](https://travis-ci.org/jason1122g/JBrat.svg?branch=JBrat2)](https://travis-ci.org/jason1122g/JBrat)
JBrat is a java framework for developing desktop application in MVC structure.

### Features
- Built-in gradle build file
- Customizable file layout
- Router setting for mvc
- Integrate with logger
- Handle I18n in both view template and text

### Modules
- jbrat-core      : include classes for jbrat programming
- jbrat-generator : include the generator of components and project

### Install
1. [Download](https://github.com/jason1122g/JBrat/releases) the zip and extract
2. Copy the directory ``` jbrat-x.x.x ``` to somewhere else you like
3. Add the path of ``` jbrat-x.x.x/bin ``` into environment variable

### Init a project
- Execute command ``` jbrat init [project name] ```

### Init a view
- Execute command ``` jbrat g view [view name] ```
- Execute command ``` jbrat generate view [view name] ```