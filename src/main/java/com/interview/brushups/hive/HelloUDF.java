package com.interview.brushups.hive;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

/**
 * The simple API (org.apache.hadoop.hive.ql.exec.UDF) can be used so long as function reads and returns primitive types.
 * By this I mean basic Hadoop & Hive writable types - Text, IntWritable, LongWritable, DoubleWritable, etc.
 * However, if you plan on writing a UDF that can manipulate embedded data structures, such as Map, List, and Set,
 * then you’re stuck using org.apache.hadoop.hive.ql.udf.generic.GenericUDF, which is a little more involved.
 */
class HelloUDF extends UDF {

    /**
     *
     * @param input
     * @return Text
     *
     * UDF class is @deprecated, Hive Expects us to extend GenericUDF instead.
     */
    public Text evaluate(Text input) {
        return new Text("Hello " + input.toString());
    }
}