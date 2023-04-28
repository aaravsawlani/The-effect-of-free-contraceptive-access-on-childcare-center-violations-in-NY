The project is set up by running the setup.sh script. This creates the hdfs directory structure that we will be using for our analytic.

The setup is as follows:
- final_project
  - data_ingest
    - clean
    - dirty

Our two original data files, condom_data.csv and cc_inspections.csv, are then placed into final_project/data_ingest/dirty. The clean directory is made to hold the output of our two MapReduce programs that clean the data, removing records and normalizing our data for future join queries. 

We then have to clean our code. In the etl_code directory, there are two subdirectories containing programs that clean our two datasets, getting it ready to be placed into a Hive table. For each program, run compile.sh, and then runit.sh. The output of these two programs will be placed in final_project/data_ingest/clean/condom_data, and final_project/data_ingest/clean/cc_inspections. Please note that as it is, the data is spread out into different textfiles. To fix this, follow the instructions in the table_cmds.txt file located in the data_ingest directory.

Once the textfiles with the clean data have been made, we create hive tables using the commands in table_cmds.txt.

Code Profiling:

We analyze our code in two ways: A MapReduce program to count the number of records, and a bunch of sql queries using Presto. In each subdirectory under profiling_code, there is a textfile commands.txt that contains the CLI commands necessary to execute the .sql files in the directory. Copy and paste the command that you want in order to make a query and see the results.
