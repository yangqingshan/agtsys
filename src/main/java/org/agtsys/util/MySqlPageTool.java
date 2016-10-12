package org.agtsys.util;

public class MySqlPageTool {
	private Integer index;
	private Integer size=5;
	private Integer count;
	private Integer total;
	private Integer limit_begin;
	
	public MySqlPageTool(Integer index,Integer size)throws Exception{
		if(index==null){
			throw new Exception("当前页码index为null");
		}
		this.size = size;
		limit_begin=(index-1)*size;
	}
	public Integer getTotal(Integer count)throws Exception{
		if(count==null){
			throw new Exception("总记录数count为null");
		}
		return count%size==0?count%size:count%size+1;
	}
	public Integer getLimit_begin(){
		return limit_begin;
	}
	public Integer getCount(){
		return count;
	}
	public void setCount(Integer count){
		this.count=count;
	}
}
