hdfs dfs -mkdir final_project
hdfs dfs -mkdir final_project/data_ingest
hdfs dfs -mkdir final_project/data_ingest/dirty
hdfs dfs -mkdir final_project/data_ingest/clean
hdfs dfs -put cc_inspections.csv final_project/data_ingest/dirty
hdfs dfs -put condom_data.csv final_project/data_ingest/dirty