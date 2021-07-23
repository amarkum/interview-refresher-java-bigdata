# Kafka Notes

## Topics
A Particular Stream of data
- Same as table in database
- It is identified by its name

Topics are Split in `Partitions`
- A partition has a message written to it, sequentially often termed as `offset`
- Each partition can have different number of offset and are independent.

### Topic Writes
- The message to a partition is determined by the key. <br>
- The message is written to the partition based on the hash key<br/>
If we have determined the key, then message will be written to specific partition, based on the hash value.

E.g There are 3 partitions, the has could be from 0 to 3
ID with 246,254 has hash value 0 , ID 296,256 has value 1 and  ID 344,844 has has value 2<br/>
Hence, the data from this ID,wll always land up in the same partition.

## Brokers
- A Kafka Cluster is composed of many brokers
- Each Broker is identified by its ID
- Each Broker contains certain topic partitions
- After connecting to bootstrap broker, we will connect to entire cluster

Example <br/>

- If topic "A" has 2 partitions and in 3 brokers cluster, 2 broker will have one partition each and 3 will not have any partition
- If topic "B" has 3 partitions and in 3 brokers cluster, Each broker will have one partition
- If topic "C" has 4 partitions and in 3 brokers cluster, 3 broker will have one partition each and one of broker will have 1 more partition

## Topic Replication
- Topic should have a replication factor > 1, 2 is risky, 3 is GOLD standards

### Leaders
- At a give point of time, only ONE broker can be leader for a given partition.
- Only that leader can receive and serve data for a partition
- Other brokers will synchronize the data, also called - ISR
- Therefore, each partition has 1 leader and multi In-Sync Replicas

## Producers
- Producer write data to topic (which is made of partitions)
- Producer automatically know to which broker and partitions to write to
- If data is sent without keys, producer sends data to partitions in round-robin fashion to load-balance
- Producer can choose to receive acknowledgement of data writes to partition: <br/>

    1. `acks=0` - Producer won't wait for acknowledgement (possible data loss) <br/>
    2. `acks=1` - Producer will wait for leader to acknowledge , (default) <br/>
    3. `acks=all` - Leader + Replica Acknowledgement (ISR) (No data loss)
    
## Consumers
- Consumers read data from a topic
- Consumers know which broker to read from
- Data is read in order with each partitions

### Consumer Group
- Consumer read in consumers group
- If you have more consumers in consumer group, consumers will be inactive.

Example<br/>
- If we have 1 consumer in consumer group, it will read from all 3 partitions
- If we have 2 consumer, 1 can read from 1 partition, and 1 can read from 2.
- If we have 3 consumer, each can read from exclusive partition.
- If we have 4 consumer, 3 can read from exclusive partition, and 1 can be idle.

## Offsets
- `__consumer_offset` is the topic to store committed offset in the newer kafka version
- when a consumer in a group has processed the data, received from kafka, it should be commits the offset.

### Delivery Semantics
1. At most once<br>
 - Offsets are committed as soon as the message is received<br/>
 - If the processing goes wrong, message will be lost
 
2. At least once<br/>
 - offsets are committed after the message is processed.
 - If the processing goes wrong, the message will be read again.
 - This can lead to duplicate processing of the message, stream processor must be able to handle it.
 
## Kafka Broker Discovery
 - Every kafka broker is also called as "bootstrap server"
 - If you connect to one broker, you will be connected to entire cluster
 - Each broker knows about all brokers, topics and partitions
 
## ZooKeeper
 - ZooKeeper manages brokers
 - ZooKeeper helps in leader election for partition
 - ZooKeeper sends notification to Kafka in case of changes<br/>
 (new topic, broker dies, broker is back, topic deleted etc.)
 - ZooKeeper operates with an odd number of server (3,5,7)
 - ZooKeeper has a leader(handle writes), the rest of the servers are follower(handle reads)
 - ZooKeeper does not store consumer offset from > 0.10
 
 
## Kafka CLI Commands
#### 1. Create a Topic<br/>
DEPRECATED<br/>
`./kafka-topics --create --topic test-topic --partitions 3 --replication-factor 1 --zookeeper localhost:2181`<br/>
 
 NEW<br/>
`./kafka-topics --create --topic test-topic --partitions 3 --replication-factor 1 --bootstrap-server localhost:9092`
 
#### 2. List all Topics
 
DEPRECATED<br/>
`./kafka-topics --list --zookeeper localhost:2181`<br/>
 
NEW<br/>
`./kafka-topics --list --bootstrap-server localhost:9092`<br/>
 
#### 3. Describe a Topic
 
DEPRECATED<br/>
`./kafka-topics --describe --topic test-topic --zookeeper localhost:2181`<br/>
 
NEW<br/>
`./kafka-topics  --describe --topic test-topic --bootstrap-server localhost:9092`
 
#### 4. Delete a Topic
 
DEPRECATED<br/>
`./kafka-topics --delete --topic test-topic --zookeeper localhost:2181`<br/>
 
NEW<br/>
`./kafka-topics --delete --topic test-topic --bootstrap-server localhost:9092`<br/>
 
#### 5. Produce to a Topic
`./kafka-console-producer  --topic test-topic --broker-list localhost:9092`<br/>
   
#### 6. Consume from a Topic
`./kafka-console-consumer --topic test-topic --bootstrap-server localhost:9092`
   
#### 7. Consume from a Consumer Group from Topic   
`./kafka-console-consumer --topic test-topic --bootstrap-server localhost:9092 --group cg1`
 
#### 8. Consume from a Consumer Group from Beginning
`./kafka-console-consumer --topic test-topic --bootstrap-server localhost:9092 --group cg2 --from-beginning`<br/>

If we start reading to new consumer group, we should read from the very beginning, and kafka commits the offset.<br/>
When it has finished reading from beginning. Now if are consumer(s) goes down, and kafka still produces some message<br/>
It will clear off the backlog message by reading it, and read the ew upcoming messages.<br/>

## Kafka Consumer Group CLI Commands
 
#### 1. List all the Consumer Groups<br/>
`./kafka-consumer-groups --list --bootstrap-server localhost:9092`

Note : When we read a message from a topic, it's always read as a part of consumer group. <br/>
We may not enter a consumer group while reading a topic, but consumer group is always created. <br/>
When we list all consumer group using the CLI command, we can see some unknown consumer group created by kafka.<br/>

#### 2. Describe a Specific Consumer Group<br/>
`./kafka-consumer-groups --describe --group cg1 --bootstrap-server localhost:9092`
 
Note : While consumer(s) are actively consuming messages, we can see which consumer are consuming which partition.<br/>
It also tells us, which consumer are at which IP.<br/>
While, it's inactive, it displays the lag and the offset of the partition.

#### 3. Consumer Group - Reset Offset<br/>
`./kafka-consumer-groups --group cg1 --bootstrap-server localhost:9092 --reset-offsets --to-earliest --topic test-topic --execute`

Note : We can use `--reset-offsets` flag to reset offset with several options available.<br/>
We can reset offsets of a specific topic in consumer group by `--topic test-topic` OR `--all-topics` for all Topics

## Can 1 Consumer Group subscribe to 2 different Topics?
Yes, this can possibly exists.
But the message will be again split into the consumer who has subscribed to a specific partition
There is no interference.
 
## Kafka Config
 
### Idempotence
`enable.idempotence=true` && `min.insync.replicase=2`
- Implies `acks=all`, `retries=MAX_INT`, `max.in.flight.requests.per.connection=5`<br/>
This make sure consumer does not commit the message twice, and maintains key level ordering.

### linger.ms & batch.size
-  by default, kafka tries to send record as soon as possible.
    - it will have unto 5 requests in flight, meaning unto 5 messages individually sent at the same time
    - after this, if more message has to be sent, kafka starts batching these message.
- batching allow throughput and maintains low latency.

### Hashing formula
By default, key is hashed based on "murmur2" algorithm

## Produce & Consume Record - Programmatically

### 1. Producer API
```java
// Create instance for properties to access producer configs
Properties props = new Properties();

// Map BOOTSTRAP_SERVERS_CONFIG from ProducerConfig to properties
props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");

// Define a Topic Name
String topicName = "test-topic";

// Create a Kafka Producer, put in the configuration properties.
KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);
   
// Create a new Producer Record | (topicName, Value) OR (topicName, Key, Value)
ProducerRecord<String, String> record = new ProducerRecord(topicName, "Key", "Value");

// Send the ProducerRecord to KafkaProducer using send() method
producer.send(record, new Callback()
```   

### 2. Consumer API
```java
// Create instance for properties to access producer configs
Properties props = new Properties();

// Map BOOTSTRAP_SERVERS_CONFIG from ConsumerConfig to properties
props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");

// Name the consumer group to using ConsumerConfig in Properties
props.put(ConsumerConfig.GROUP_ID_CONFIG, "consumer-group-one");

// Declare Topics to Subscribe
String topicName = "test-topic";

// Create a Kafka Consumer
KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);

// Kafka Consumer subscribes list of topics here.
consumer.subscribe(Arrays.asList(topicName));

// Get ConsumerRecords by using poll() method from KafkaConsumer
ConsumerRecords<String, String> records = consumer.poll(100);

// Iterate ConsumerRecords and get the key,value & offset information
for (ConsumerRecord<String, String> record : records)
    record.offset(), record.key(), record.value()
```


## How to install and run Kafka?
Apache Kafka also uses zookeeper server for synchronisation service.\
So we must be sure we have already installed and running zookeeper service before. \
If you have started the `confluent`, Kafka will already be running and using the `zookeeper` which confluent starts.

### Download and Extract
Download the latest binary distribution of [kafka](https://www.apache.org/dyn/closer.cgi?path=/kafka/)
 
 e.g.[kafka_2.11-2.2.0.tg](http://mirrors.estointernet.in/apache/kafka/2.2.0/kafka_2.11-2.2.0.tgz)
 
 1) Unzip it to your home folder e.g. `/Users/ak054561/` through MacOS default extract utility or you may use relevant command line tools to extract.
 2) Rename the folder to `kafka` from `kafka.XX.XX.XX`
 3) Edit already existing file in `kafka/conf/` folder `server.properties` and make sure below is existing in properties file. (If already existing, ignore.)
 ```
 zookeeper.connect=localhost:2181
 ```
 4) Edit `zookeeper.properties` file in `kafka/conf/` directory and set 
 ```
 dataDir=/Users/ak054561/data/zookeeper
 ```
 
### Test Kafka Installation
 1) Open up a new terminal, navigate to kafka folder with
 ```
 $ cd ~
 $ cd kafka
 $ bin/kafka-server-start.sh -daemon config/server.properties
 ```
 
 2) Open up a new terminal, navigate to kafka folder and create a `topic`
 ```
 bin/kafka-topics.sh --create  --bootstrap-server localhost:9092 --topic test-topic --partitions 2 --replication-factor 1
 ```
 3) Produce a message. \
     Open up a new terminal, navigate to kafka folder and produce a message on topic
 ```
 bin/kafka-console-producer.sh --broker-list localhost:9092 --topic test-topic
 ```
 4) Consume a message. \
     Open up a new terminal, navigate to kafka folder and consume a message on topic from beginning
 
 ```
 bin/kafka-console-consumer.sh  --bootstrap-server localhost:9092 --topic test-topic --from-beginning
 ```
 \
 <image src="https://i.ibb.co/VDNCqgD/04-kafka-images.png" width="640" height="340">
