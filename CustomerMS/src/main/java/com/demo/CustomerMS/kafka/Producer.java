package com.demo.CustomerMS.kafka;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.demo.CustomerMS.kafka.entity.Record;

public class Producer {

	private final static String BOOTSTRAP_SERVERS = "localhost:9092";
	
	@Value("${loggingfile}")
	private String logDir;

	private static KafkaProducer<String, String> createProducer() {

		Properties props = new Properties();

		// putting details of kafka broker
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
		props.put(ProducerConfig.CLIENT_ID_CONFIG, "TestTopic");
		props.put("linger.ms", 1);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		return new KafkaProducer<String, String>(props);

	}

	public static void main(String[] args) throws IOException, ParseException {
		final KafkaProducer<String, String> testTopicProducer = createProducer();
		// Scanner streamIndput = new Scanner(new File(args[0]));
		Producer p = new Producer();

		String key = "message";

//		Path logFilePath = Paths.get(p.logDir).toAbsolutePath().normalize();
//		Path logFile = logFilePath.resolve("spring-boot-logger.log");
//		File file = new File(logFile.toString());
		
//		Resource r = new ClassPathResource("../../../logs/spring-boot-logger.log");
//		
//		File file = r.getFile(); 
		
//		System.out.println(file.getAbsolutePath());
		
		
		 File file = new File(
				"/home/lappy/Documents/workspace-spring-tool-suite-4-4.5.1.RELEASE/Microservices-Task/CustomerMS/logs/spring-boot-logger.log");

		BufferedReader br = new BufferedReader(new FileReader(file));
		String st;
		while ((st = br.readLine()) != null) {

			JSONObject jsonObject = (JSONObject) readJSON(st);
			String record = processJSON(jsonObject);

			final ProducerRecord<String, String> Record = new ProducerRecord<String, String>("TestTopic", key, record);
			testTopicProducer.send(Record);

		}

		testTopicProducer.close();
		br.close();
		System.out.println("Completed printing records");
	}

	public static Object readJSON(String str) throws ParseException {
		JSONParser jsonParser = new JSONParser();
		return jsonParser.parse(str);
	}

	public static String processJSON(JSONObject obj) {
		Record rec = new Record();
		rec.setTime((String) obj.get("@timestamp"));
		rec.setApplication_name((String) obj.get("application_name"));
		rec.setTrace_id((String) obj.get("trace_id"));
		rec.setSpan_id((String) obj.get("span_id"));
		rec.setParentSpanId((String) obj.get("parent_span_id"));
		rec.setLevel((String) obj.get("level"));
		return rec.toString();

	}

}
