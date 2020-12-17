package com.spring.ch_04.study_02;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TrackCounter {

	private Map<Integer, Integer> trackCounts = new HashMap<Integer, Integer>();
	
	/**
	 * ����int���Ͳ���,���������������뵽֪ͨ������
	 * ��������Ҫ��Ӧ
	 * @param trackNumber
	 */
	@Pointcut("execution(* com.spring.ch_04.study_02.CompactDisc.playTrack(int)) && args(trackNumber)")
	public void trackPlayed(int trackNumber){}
	
	@Before("trackPlayed(trackNumber)")
	public void countTrack(int trackNumber){
		System.out.println("ǰ��֪ͨ");
		int currentCount = getPlayCount(trackNumber);
		trackCounts.put(trackNumber, currentCount+1);
	}
	
	public int getPlayCount(int trackNumber){
		return trackCounts.containsKey(trackNumber) ? trackCounts.get(trackCounts) : 0;
	}
}
