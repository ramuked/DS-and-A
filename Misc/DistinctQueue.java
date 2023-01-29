import java.util.*;
import java.lang.*;
import java.io.*;
public class DistinctQueue{
	
	private LinkedHashSet<Integer> queueValues;
	public DistinctQueue(){
		queueValues = new LinkedHashSet<>();
	}
	
	public void offer(int value){
		queueValues.add(value);
	}
	
	public Integer peek(){
		if(queueValues.size() == 0)throw new NoSuchElementException("Queue is empty");
		return getFirstElement();
	}
	
	public Integer poll(){
		if(queueValues.size() == 0)throw new NoSuchElementException("Queue is empty");
		Integer val = getFirstElement();
		queueValues.remove(val);
		return val;
	}
	
	private Integer getFirstElement(){
		Integer firstElement = null;
		for(Integer i : queueValues){
			firstElement = i;
			break;
		}
		return firstElement;
	
	}
	
	

}
