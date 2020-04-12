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
If we have determined the key, then message will be written to specific partition.

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