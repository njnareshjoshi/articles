package com.example;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Arrays;

@SpringBootApplication
@EnableTransactionManagement
public class SpringSparkDemoApplication implements CommandLineRunner
{
    @Autowired
    SparkIntegrationService sparkIntegrationService;

    public static void main(String[] args)
    {
        SpringApplication.run(SpringSparkDemoApplication.class, args);
    }

    @Override
    public void run(String... args)
    {
        sparkIntegrationService.testSparkOperations();
    }
}

@Configuration
@PropertySource("classpath:application.properties")
class SparkConfig
{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${app.name}")
    private String appName;

    @Value("${spark.home}")
    private String sparkHome;

    @Value("${master.uri}")
    private String masterUri;

    @Bean
    public SparkConf sparkConf()
    {
        return new SparkConf()
            .setAppName(appName)
            .setSparkHome(sparkHome)
            .setMaster(masterUri);
    }

    @Bean
    public JavaSparkContext javaSparkContext(SparkConf sparkConf)
    {
        return new JavaSparkContext(sparkConf);
    }

    @Bean
    public SparkSession spark(SparkConf sparkConf)
    {
        SparkSession sparkSession = SparkSession.builder()
            .sparkContext(javaSparkContext(sparkConf).sc())
            .config(sparkConf)
            .getOrCreate();

        logger.info("Using Spark Version {}", sparkSession.version());

        return sparkSession;
    }

}

@Service
class SparkIntegrationService
{

    @Autowired
    SparkSession spark;

    public void testSparkOperations()
    {
        Dataset<Row> csvDataSet1 = spark.read().option("header", true).csv("./src/main/resources/employees1.csv");

        System.out.println("Schema of the CSV file:");
        csvDataSet1.printSchema();

        System.out.println("Columns in CSV file:");
        System.out.println(Arrays.toString(csvDataSet1.columns()));

        System.out.println("Total data set 1 count: " + csvDataSet1.count());

        System.out.println("First 5 rows:");
        Row[] head = (Row[]) csvDataSet1.head(5);
        System.out.println(Arrays.toString(head));

        Dataset<Row> csvDataSet2 = spark.read().option("header", true).csv("./src/main/resources/employees2.csv");

        System.out.println("Total data set 2 count: " + csvDataSet2.count());
        System.out.println();

        Dataset<Row> dataSetUnion = csvDataSet1.union(csvDataSet2);
        System.out.println("Total data set union count: " + dataSetUnion.count());
    }
}
