# Kafka Notes

## Topics
A Particular Stream of data
- Same as table in database
- It is identified by it's name

Topics are Split in `Partitions`
- A partition has a message written to it, sequentially often termed as `offset`
- Each partition can have different number of offset and are independent.

### Topic Writes
- The message to a partition is determined by the key. <br>
- The message are written to the partition based on the hash key<br/>
If we have determined the key, then message will be written to specific partition, based on the hash value.

E.g There are 3 partitions, the has could be from 0 to 3
ID with 246,254 has hash value 0 , ID 296,256 has has value 1 and  ID 344,844 has has value 2<br/>
Hence, the data from this ID,wll always land up in the same partition.

## Brokers
- A Kafka Cluster is composed of many brokers
- Each Broker is identified by it's ID
- Each Broker contains certain topic partitions
- After connecting to bootstrap broker, we will connected to entire cluster

Example <br/>
- If topic "A" has 3 partitions and in 3 brokers cluster, Each broker will have one partition
- If topic "B" has 2 partitions and in 3 brokers cluster, 2 broker will have one partition and 3 will not broker will not have any partition
- If topic "C" has 4 partitions and in 3 brokers cluster, 3 broker will have one partition each and a broker will have 1 more partition

## Topic Replication
- Topic should have a replication factor >1, 2 is risky, 3 is GOLD standards

### Leaders
- At a give point of time, only ONE broker can be leader for a given partition.
- Only that leader can receive and serve data for a partition
- Other brokers will synchronize the data, also called - ISR
- Therefore, each partition has 1 leader and multi In-Sync Replicas

## Producers
- Produce write data to topic (which is made of partitions)
- Producer automatically know to which broker and partitions to write to
- If data is sent without keys, producer sends data to partitions in round-robin fashion to load-balance
- Producer can choose to receive acknowledgement of data writes to partitions: <br/>

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