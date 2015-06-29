package com.talentica.friendList;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FriendFinder {
	
	//for optimization we were using array 
	private static int nodeFriend[] ;
	//For optimization we will calculate the highest index of array
	private static int maxValueOfNode=0;
	
	/*
	 * initializing array of nodefriend from Query
	 * assuming node in a tree are random and  
	 */
	private static void init(String path){
		 FileReader fileReader;
		 BufferedReader bufferedReader ;
		 try {
			 fileReader = new FileReader(path);	
	         bufferedReader = new BufferedReader(fileReader);
	         String line = null;
	        	 while ((line = bufferedReader.readLine()) != null) {
	        		 int value = new Integer(line.trim());
					 if(maxValueOfNode<value){
						maxValueOfNode=value;
					 }
				  }
	        	 nodeFriend = new int[maxValueOfNode+1];
	        	 initArray(path);
				bufferedReader.close();
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	        			 
	}
	
	private static void initArray(String path) {
		// TODO Auto-generated method stub
		 FileReader fileReader;
		 BufferedReader bufferedReader ;
		 try {
			 fileReader = new FileReader(path);	
	         bufferedReader = new BufferedReader(fileReader);
	         String line = null;
	        	 while ((line = bufferedReader.readLine()) != null) {
	        		 int value = new Integer(line.trim());
					 nodeFriend[value]=-1;
				  }
				bufferedReader.close();
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	        			 
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter path to queries file containing node : ");
		String path1 = scanner.next();
		System.out.print("Enter path to com-orkut.ungraph.txt file containing graph of Orkut friends : ");
		String path2 = scanner.next();
		long before = System.currentTimeMillis();
		init(path1);//"D:\\Problem_statement_talentica\\workspace\\FriendList\\src\\main\\resources\\queries"
		countFriend(path2);//"D:\\Problem_statement_talentica\\workspace\\FriendList\\src\\main\\resources\\com-orkut.ungraph.txt"
		printFriendCount();


	}

	private static void printFriendCount() {
		// TODO Auto-generated method stub
		for(int i = 0; i <= nodeFriend.length - 1; i++){
			if(nodeFriend[i]!=-1&&nodeFriend[i]!=0){
				System.out.println(i +" : "+nodeFriend[i]);
			}
		}
		
	}

	private static void countFriend(String path) {
		// TODO Auto-generated method stub
		 FileReader fileReader;
		 BufferedReader bufferedReader ;
		 try {
			 fileReader = new FileReader(path);	
	         bufferedReader = new BufferedReader(fileReader);
	         String line = null;
	         try {
	        	 while ((line = bufferedReader.readLine()) != null) {
	        		int key= new Integer(line.split("\t")[0]); 
	        		if(nodeFriend[key]!=0){
	        			if(nodeFriend[key]==-1){
	        				nodeFriend[key]=1;
	        			}else{
	        				nodeFriend[key]++;
	        			}
	        		}
	        	 }
	        	 bufferedReader.close();
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	        
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
