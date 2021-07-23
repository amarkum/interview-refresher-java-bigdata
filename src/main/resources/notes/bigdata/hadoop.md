# Hadoop Library

## Hadoop Commons
`hadoop-common` refers to the commonly used utilities and libraries that support the Hadoop modules.
## Hadoop Core
`hadoop-core` is the same as Hadoop-common; It was renamed to Hadoop-common in July 2009, per https://hadoop.apache.org/.
## Hadoop Client
`hadoop-client` refers to the client libraries used to communicate with Hadoop's common components (HDFS, MapReduce, YARN) including but not limited to logging and codecs for example.

Hadoop 2.X
```xml
<!-- https://mvnrepository.com/artifact/org.apache.hadoop/hadoop-client -->
<dependency>
    <groupId>org.apache.hadoop</groupId>
    <artifactId>hadoop-client</artifactId>
    <version>2.10.0</version>
</dependency>
```

Hadoop 3.X
```xml
<!-- https://mvnrepository.com/artifact/org.apache.hadoop/hadoop-client -->
<dependency>
    <groupId>org.apache.hadoop</groupId>
    <artifactId>hadoop-client</artifactId>
    <version>3.2.1</version>
</dependency>
```

For developers who build apps that submit to YARN, run a MR job, or access files from HDFS use Hadoop-client libraries.

## Difference between Hadoop 0.20 & Hadoop 1.X & Hadoop 2.X
Hadoop 1.X & Hadoop 2.X uses the `org.apache.hadoop.mapreduce` package, and use `context` object to communicate with MapReduce system and Job control is done through the JOB class.<br/>
While older uses `org.apache.hadoop.mapred` package, and use JobConf, the OutputCollector, and the Reporter object use for communicate with MapReduce System also Job Control was done through JobClient.


## How to Write a MapReduce Job

```java
/**
 * Create a new Configuration, add up whatever the values required in configuration.
 */
Configuration conf = new Configuration();

/**
 * Create a new Job Instance, get a new Job Instance via getInstance()
 */
Job job = Job.getInstance(conf,"word-count-job");

/**
 * Set the Mapper, Combiner and Reducer Class.
 * It is not necessary the Combiner class will be called in Hadoop.
 */
job.setMapperClass(WordCountMapper.class);
job.setCombinerClass(WordCountReducer.class);
job.setReducerClass(WordCountReducer.class);

/**
 * Set the output key and value Class.
 */
job.setOutputKeyClass(Text.class);
job.setOutputValueClass(IntWritable.class);

/**
 * Set the input and output path.
 */
FileInputFormat.addInputPath(job, new Path(args[0]));
FileOutputFormat.setOutputPath(job, new Path(args[1]));

System.exit(job.waitForCompletion(true) ? 0 : 1);
```

## When we need to Specify the Map's `<K,V>` output class in job?
If the output `<K,V>` of the Reducer is not as same as the Mapper's `<K,V>`.

```java
job.setMapOutputKeyClass(IntWritable.class);
job.setMapOutputValueClass(IntWritable.class);
```

## How to add cache files which is available across all nodes?
The data file must be present into HDFS as primary requirement.

```java
job.addCacheFile(new URI("hdfs://quickstart.cloudera:8020/user/cloudera/cache-files/cached-data.txt"));
```

We can call out `setup()` method, in the Mapper or Reducer class to read the data from the file.
```java
        ArrayList<String> stopWords = null;
        public void setup(Context context) throws IOException, InterruptedException
        {
            stopWords = new ArrayList<String>();
            URI[] cacheFiles = context.getCacheFiles();
            if (cacheFiles != null && cacheFiles.length > 0)
            {
                try {
                    String line = "";
                    FileSystem fs = FileSystem.get(context.getConfiguration());
                    Path filePath = new Path(cacheFiles[0].toString());
                    BufferedReader reader = new BufferedReader(new InputStreamReader(fs.open(filePath)));
                    while ((line = reader.readLine()) != null)
                    {
                        String[] words = line.split(" ");
                        for (int i = 0; i < words.length; i++)
                        {
                            stopWords.add(words[i]);
                        }
                    }
                }
                catch (Exception e)
                {
                    System.out.println("Unable to read the File");
                    System.exit(1);
                }
            }
        }
```

## How the file is read from HDFS in MapReduce?

By Default Record Reader reads the file in `KeyValueTextInputFormat`.
We can specify the same using `setInputFormatClass()`

```java
job.setInputFormatClass(TextInputFormat.class);
```
Map Reduce has several file input format which can be set, default is `TextInputFormat`. </br>
```text
1. FileInputFormat 
2. TextInputFormat 
3. KeyValueTextInputFormat 
4. SequenceFileInputFormat 
5. SequenceFileAsTextInputFormat 
6. SequenceFileAsBinaryInputFormat 
7. NlineInputFormat 
```

## Shuffling & Sorting
Shuffle group all the `value` with similar `key` taking the input from the map input.</br>
In the Shuffle phase `sorting` is also performed based on the key's value, after which the reducer can work on it.



