class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        int[] cur = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= cur[1]) {
                cur[1] = Math.max(cur[1], intervals[i][1]);
            } else {
                res.add(cur);
                cur = intervals[i];
            }
        }
        res.add(cur);
        return res.toArray(new int[res.size()][]);
    }
}

class Solution {
    public int[][] merge(int[][] intervals) {
        int length=intervals.length;
        if(length==1)
        {
            return intervals;
        }
        int max=0;
        for(int i=0;i<length;i++)
        {
            if(intervals[i][0]>max)
            {
                max=intervals[i][0];
            }
            if(intervals[i][1]>max)
            {
                max=intervals[i][1];
            }
        }
        int count[]=new int[max+1];
        for(int i=0;i<length;i++)
        {
            if(intervals[i][0]==intervals[i][1])
            {
                if(count[intervals[i][0]]==0)
                {
                    count[intervals[i][0]]=4;
                }
            }
            else
            {
                if(count[intervals[i][0]]==0||count[intervals[i][0]]==4)
                {
                    count[intervals[i][0]]=2;
                }
                else if(count[intervals[i][0]]==3)
                {
                    count[intervals[i][0]]=1;
                }
                if(count[intervals[i][1]]==0||count[intervals[i][1]]==4)
                {
                    count[intervals[i][1]]=3;
                }
                else if(count[intervals[i][1]]==2)
                {
                    count[intervals[i][1]]=1;
                }
            }
        }
        for(int i=0;i<length;i++)
        {
            for(int j=intervals[i][0]+1;j<intervals[i][1];j++)
            {
                count[j]=1;
            }
        }
        int pin=0;
        for(int i=0;i<=max;i++)
        {
            if(count[i]==2)
            {
                intervals[pin][0]=i;
            }
            else if(count[i]==3)
            {
                intervals[pin][1]=i;
                pin++;
            }
            else if(count[i]==4)
            {
                intervals[pin][0]=i;
                intervals[pin][1]=i;
                pin++;
            }
        }
        int answer[][]=new int[pin][2];
        for(int i=0;i<pin;i++)
        {
            answer[i]=intervals[i];
        }
        return answer;
    }
}