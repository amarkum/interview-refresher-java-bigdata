package com.interview.brushups.crunch;

import org.apache.crunch.*;
import org.apache.crunch.impl.mr.MRPipeline;
import org.apache.crunch.io.To;
import org.apache.crunch.types.avro.Avros;
import org.apache.hadoop.conf.Configuration;

public class CrunchPersonRecordsToAvro {
    public static void main(String[] args) {

        // Input and Output path
        String inputPath = args[0];
        String outputPath = args[1];

        //Create a new Hadoop Job Configuration
        Configuration configuration = new Configuration();

        //Create a Pipeline
        Pipeline pipeline = getPipeline(configuration);

        //Read PCollection of String from Text file.
        PCollection personDataEachLine = pipeline.readTextFile(inputPath);

        //Create a PCollection of Person record.
        PCollection personRecord = personDataEachLine.parallelDo(DoFnCreatePerson(), Avros.records(Person.class));

        //Write collection to avro file.
        personRecord.write(To.avroFile(outputPath));

        PipelineResult result = pipeline.done();
        System.exit(result.succeeded() ? 0 : 1);
    }

    public static DoFn<String, Person> DoFnCreatePerson() {
        return new DoFn<String, Person>() {
            @Override
            public void process(String input, Emitter<Person> emitter) {
                String inputParts[] = input.split(",");
                String name = inputParts[0];
                String roll = inputParts[1];
                String city = inputParts[2];
                emitter.emit(new Person(name, roll, city));
            }
        };
    }

    public static Pipeline getPipeline(final Configuration conf) {
        conf.setBoolean("mapred.output.compress", false);
        return new MRPipeline(Person.class, conf);
    }
}