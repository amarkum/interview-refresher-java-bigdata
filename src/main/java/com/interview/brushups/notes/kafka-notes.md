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
