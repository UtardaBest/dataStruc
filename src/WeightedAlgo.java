
import java.util.*;
import java.util.function.ToIntFunction;

class Job
{
    int startDate, finishDate, profit;

    Job(int startDate, int finishDate, int profit)
    {
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.profit = profit;
    }
}

class WeightedAlgo
{

    public static int weigthedAlgoMethod(List<Job> jobs)
    {

        jobs.sort(Comparator.comparingInt(new ToIntFunction<Job>() {
            @Override
            public int applyAsInt(Job x) {
                return x.startDate;
            }
        }));

        int[] maximumProfitForEachProbability = new int[jobs.size()];

        if (jobs.size() == 0) {
            return 0;
        }

        for (int i = 0; i < jobs.size(); i++)
        {
            maximumProfitForEachProbability[i] = 0;
            for (int j = 0; j < i; j++)
            {
                if (jobs.get(i).startDate>=jobs.get(j).finishDate) {
                    if (maximumProfitForEachProbability[i] < maximumProfitForEachProbability[j]) {
                        maximumProfitForEachProbability[i] = maximumProfitForEachProbability[j];
                    }
                }
            }
            maximumProfitForEachProbability[i] += jobs.get(i).profit;
        }

        int biggestProfit=0;

        for (int i : maximumProfitForEachProbability) {
            if (biggestProfit < i) {
                biggestProfit = i;
            }
        }
        //        return Arrays.stream(maxProfit).max().getAsInt();
        return biggestProfit;
    }

    public static void main(String[] args)
    {
        List<Job> jobs =new ArrayList<>();
        jobs.add(new Job(1,3,5));
        jobs.add(new Job(1,3,5));
        jobs.add(new Job(1,3,5));
//        jobs.add(new Job(2,5,6));
//        jobs.add(new Job(4,6,5));
//        jobs.add(new Job(6,7,4));
//        jobs.add(new Job(5,8,11));
//        jobs.add(new Job(7,9,2));
        if(weigthedAlgoMethod(jobs)==0){
            System.out.println("Array no items" );
        }
        else{
            System.out.println("WeightedAlgo: " + weigthedAlgoMethod(jobs));
        }

    }
}
