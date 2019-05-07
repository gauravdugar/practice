package com.gd.practice.old;

import java.util.ArrayList;
import java.util.Arrays;

class Meeting implements Comparable<Meeting>{
	private int startTime;
	private int endTime;
	
	Meeting(int start, int end) {
		this.startTime = start;
		this.endTime = end;
	}
	
	int getStart() {
		return startTime;
	}
	
	int getEnd() {
		return endTime;
	}
	
	@Override
	public String toString() {
		return ("Meeting- [start:" + startTime + " end:" + endTime + "]");
	}

	@Override
	public int compareTo(Meeting o) {
		return this.getStart() - o.getStart();
	}
}

public class MeetingMerge {
	
	private static ArrayList<Meeting> merge(Meeting[] m1) {
		ArrayList<Meeting> result = new ArrayList<>();
		int start = m1[0].getStart();
		int end = m1[0].getEnd();
		
		for (int i=0; i<m1.length-1; i++) {
			if(end < m1[i+1].getStart()) {
				result.add(new Meeting(start,end));
				start = m1[i+1].getStart();
				end = m1[i+1].getEnd();
			}
			else if(end < m1[i+1].getEnd())
					end = m1[i+1].getEnd();
		}
		result.add(new Meeting(start,end));
		return result;
	}
	
	public static void main(String[] args) {
		Meeting[] meetings = new Meeting[] {new Meeting(0,1),new Meeting(3,5),new Meeting(4,8),new Meeting(10,12),new Meeting(9,10)};		
		Arrays.sort(meetings);
		System.out.println(Arrays.toString(meetings) + "\n");
		ArrayList<Meeting> mergedMeetings = merge(meetings);
		System.out.println(mergedMeetings.toString());
	}
}