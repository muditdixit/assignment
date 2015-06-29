package com.talentica.processFlow;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;


public class ProcessFlow {
	
	private static HashMap<Integer,Integer> flowContainer =new HashMap<Integer, Integer>();

	public static void main(String[] args) throws InvalidArgumentException {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter path to valid csv file: ");
		String path = scanner.next();
		// TODO Auto-generated method stub
		//long before = System.currentTimeMillis();
		//String path ="D:\\Problem_statement_talentica\\workspace\\ProcessFlow\\src\\main\\resources\\event_logs.csv";
		readCSVFile(path);//path);//args[0]);151
		printMostFrequentPattern();
		//long after = System.currentTimeMillis();
		//System.out.println((after - before) + " milliseconds");

	}

	private static void printMostFrequentPattern() {
		// TODO Auto-generated method stub
		Entry<Integer, Integer> maxEntry = null;

		for (Entry<Integer, Integer> entry : flowContainer.entrySet())
		{
		    if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
		    {
		        maxEntry = entry;
		    }
		}
		char[] flow = maxEntry.getKey().toString().toCharArray();
		System.out.println("Start-->"+flow[0]+"-->"+flow[1]+"-->"+flow[2]+"-->"+flow[3]+"-->"+flow[4]+"-->"+flow[5]+"-->"+flow[6]+"-->"+flow[7]+"-->"+flow[8]+"-->End");
	}



	private static void readCSVFile(String path) {
		// TODO Auto-generated method stub	
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		int previuosCaseId=0;
		int serviceFlow=0;
		int noLine=0;
		try {	 
			br = new BufferedReader(new FileReader(path));
			//read line by line
			while ((line = br.readLine()) != null) {
			    // use comma as separator
				if(noLine!=0){
					String[] logLine = line.split(cvsSplitBy);
					int caseId=new Integer(logLine[0]);
					//condition for new instance of service PO
					if(previuosCaseId!=caseId || previuosCaseId==0){
						if(noLine!=1){
							if(flowContainer.containsKey(serviceFlow)){
								//increment the count
								int currentCount= flowContainer.get(serviceFlow);
								flowContainer.put(serviceFlow, (currentCount+1));
							}else{//create a new process with case id and add it to hashmap
								flowContainer.put(serviceFlow, 1);
							}
						}
						serviceFlow=0;
						serviceFlow=serviceFlow*10+Service.valueOf(logLine[1]).getNo();
					}else{
						serviceFlow=serviceFlow*10+Service.valueOf(logLine[1]).getNo();				
					}
					previuosCaseId=caseId;
				}				
				noLine++;
			}	 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
Mudit Dixit
