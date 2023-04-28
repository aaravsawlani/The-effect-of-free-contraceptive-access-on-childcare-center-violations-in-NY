javac -classpath `yarn classpath`:libs/opencsv-5.2.jar -d . CountRecsMapper.java
javac -classpath `yarn classpath` -d . CountRecsReducer.java
javac -classpath `yarn classpath`:. -d . CountRecs.java
jar -cvf countRecs.jar *.class