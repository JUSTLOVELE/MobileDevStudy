package com.util.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class TextFile extends ArrayList<String>{

	private static final long serialVersionUID = 1L;
	
	public TextFile(String fileName, String splitter) {
		super(Arrays.asList(read(fileName).split(splitter)));
	}
	
	public TextFile(String fileName){
		this(fileName, "\n");
	}
	
	public void write(String fileName){
		
		try {
			PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            try {
				for(String item:this){
					out.println(item);
				}
			} finally {
				out.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void write(String fileName, String text){
		try {
			PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
			try {
				out.print(text);
			} finally {
				out.close();
			}
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	

	public static String read(String fileName){
		
		StringBuffer sb = new StringBuffer();
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
		    try {
				String s = null;
				while((s = in.readLine()) != null){
					sb.append(s);
					sb.append("\n");
				}
			} finally{
				in.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String file = read("TextFile.java");
		write("text.txt", file);
		TextFile text = new TextFile("text.txt");
		text.write("text2.txt");
		TreeSet<String> words = new TreeSet<String>(
				new TextFile("TextFile.java", "\\w+"));
		System.out.println(words.headSet("a"));
	}
}
