package za.co.four.assignment.lindanyMabaso;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComputeController {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	ReadExcel readexcelObj = new ReadExcel();
	
	@RequestMapping(value="/createTable",method=RequestMethod.GET)
	public void createTable() {
		try {
			jdbcTemplate.execute("CREATE TABLE ROUTES("+
		"id SERIAL,routeId VARCHAR(10), origin VARCHAR(255), destination VARCHAR(255), distance VARCHAR(255))");
			
			jdbcTemplate.execute("CREATE TABLE PLANET("+
					"id SERIAL, name VARCHAR(255), node VARCHAR(255))");
			
			jdbcTemplate.execute("CREATE TABLE TRAFFIC("+
					"id SERIAL, routeId VARCHAR(10), origin VARCHAR(255), destination VARCHAR(255), delay VARCHAR(255))");
			
			System.out.print("All Tables have been succesfully Created!!!");

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/putData",method=RequestMethod.GET)
	public void updateTable() {
		try {
			ArrayList<String> planetList = readexcelObj.getPlanetList(0);
			ArrayList<String> routetList = readexcelObj.getRoutesList(1);
			ArrayList<String> trafficList = readexcelObj.getTrafficList(2);
			planetList.remove(0);
			routetList.remove(0);
			trafficList.remove(0);
			for(String line: planetList){
				if ( line.contains("'") )
				{
					line = line.replaceAll("'", "''");
				}
				String[] splited = line.split("\\s+");
				
				String record ="INSERT INTO planet (name, node) VALUES ( '"+splited[0]+"','"+ splited[1]+"')";
				jdbcTemplate.execute(record);

			}
			System.out.print("Planets records have been succesfully Inserted...");

			
			for(String line: routetList){
				if ( line.contains("'") )
				{
					line = line.replaceAll("'", "''");
				}
				String[] splited = line.split("\\s+");
				String record ="INSERT INTO ROUTES (routeId, origin, destination, distance) VALUES ('"+splited[0]+"','"+ splited[1]+"','"+ splited[2]+"','"+ splited[3]+"')";
				jdbcTemplate.execute(record);

			}
			System.out.print("Routes records succesfully Inserted...");

			
			for(String line: trafficList){
				if ( line.contains("'") )
				{
					line = line.replaceAll("'", "''");
				}
				String[] splited = line.split("\\s+");
				String record = "INSERT INTO TRAFFIC (routeId, origin, destination) VALUES ('"+splited[0]+"','"+ splited[1]+"','"+ splited[2]+"')";
				jdbcTemplate.execute(record);

			}
			
			System.out.print("All records have been succesfully Inserted!!!");
	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
