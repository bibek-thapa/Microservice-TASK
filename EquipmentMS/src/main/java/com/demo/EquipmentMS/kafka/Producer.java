package com.demo.EquipmentMS.kafka;

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
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.demo.EquipmentMS.kafka.entity.Record;

@Component
public class Producer {

	private final static String BOOTSTRAP_SERVERS = "localhost:9092";
	
	@Value("${loggingfile}")
	private String logDir;

	private  KafkaProducer<String, String> createProducer() {

		Properties props = new Properties();

		// putting details of kafka broker
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
		props.put(ProducerConfig.CLIENT_ID_CONFIG, "TestTopic");
		props.put("linger.ms", 1);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		return new KafkaProducer<String, String>(props);

	}

	@Scheduled(cron="*/1 * * * * ?")

	public void produce() throws IOException, ParseException {
		final KafkaProducer<String, String> testTopicProducer = createProducer();
		// Scanner streamIndput = new Scanner(new File(args[0]));
		

		String key = "message";

		Path logFilePath = Paths.get(logDir).toAbsolutePath().normalize();
		Path logFile = logFilePath.resolve("spring-boot-logger.log");
		File file = new File(logFile.toString());
		
	
		
		
//		 File file = new File(
//				"/home/lappy/Documents/workspace-spring-tool-suite-4-4.5.1.RELEASE/Microservices-Task/CustomerMS/logs/spring-boot-logger.log");

		BufferedReader br = new BufferedReader(new FileReader(file));
		String st;
		while ((st = br.readLine()) != null) {

			JSONObject jsonObject = (JSONObject) readJSON(st);
			String record = processJSON(jsonObject);
		
			final ProducerRecord<String, String> Record = new ProducerRecord<String, String>("TestTopic", key, record);
			testTopicProducer.send(Record);

		}

		//testTopicProducer.close();
	
		
	}

	public  Object readJSON(String str) throws ParseException {
		JSONParser jsonParser = new JSONParser();
		return jsonParser.parse(str);
	}

	public String processJSON(JSONObject obj) {
		Record rec = new Record();
		rec.setTime((String) obj.get("@timestamp"));
		rec.setApplication_name((String) obj.get("application_name"));
		rec.setTrace_id((String) obj.get("trace_id"));
		rec.setSpan_id((String) obj.get("span_id"));
		rec.setParentSpanId((String) obj.get("parent_span_id"));
		rec.setLevel((String) obj.get("level"));
		rec.setRequest((String)obj.get("request"));
		rec.setResponse((String)obj.get("response"));

		return rec.toString();

	}

}
