# Cheatsheet for JMP

This document contains useful commands that may be used for showcasing the jSparrow Maven plugin. 

## Report

```bash
mvn jsparrow:report
mvn jsparrow:report -DdefaultConfiguration
mvn jsparrow:report -DconfigFile=jsparrow1.yml
```

## Refactor

```bash
mvn jsparrow:refactor
```

## Selecting Sources

```bash
-DselectedSources="core/**"
-DselectedSources="$(git diff --name-only HEAD~10 HEAD~0)"
-DselectedSources="$(git diff-tree --no-commit-id --name-only -r HEAD~9)"
```

## Formatting

```bash
-Dprofile="format" -Dformatter=./formatter/simple-formatter.xml
-Dprofile="format" -Dformatter=./formatter/bad-formatter.xml
```
