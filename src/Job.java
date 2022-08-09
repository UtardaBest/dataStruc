import java.util.*;

public class Job implements Comparable<Job> {
    private String jobid;
    private int startdate;
    private int enddate;
    private int profit;
    
    public void setStartDate() {
    	this.startdate = startdate;
    	
    }
    public void setEndDate() {
    	this.enddate = enddate;
    	
    }
    public void setProfit() {
    	this.profit = profit;
    	
    }
	public Job() {
		this.jobid = jobid;
		this.startdate = startdate;
		this.enddate = enddate;
		this.profit = profit;
	}
	
	public void findProfitSequence(ArrayList<Job> jobs) {
		int jobsize = jobs.size();
		
		
		
	}
	@Override
	public int compareTo(Job o) {
		if (enddate == o.enddate)
			return 0;
		else if (enddate < o.enddate)
			return 1;
		else 
			return -1;
	}

}
