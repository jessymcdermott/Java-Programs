/*
Jessy McDermott
HW 9 Q 6
Nov 
*/


/*

Instance 1 - 5 items
    Income: 20, 30, 35, 12, 3
    Weight: 2, 5, 7, 3, 1
    Weight Cap: 13
    
    Solution:
        Max possible profit: 70
        Number of promising nodes: 9
        Number of non-promising nodes: 10

Instance 2 - 4 items
    Income: 40, 30, 50, 10
    Weight: 2, 5, 10, 5
    Weight Capacity: 16
    
    Solution:
        Max possible profit: 90
        Number of promising nodes: 6
        Number of non-promising nodes: 7

Instance 3 - 10 items
    Income: 11, 22, 16, 9, 4, 24, 6, 94, 92, 19
    Weight: 1, 3, 5, 7, 9, 22, 44, 66, 88, 2
    Weight Cap: 90
    
    Solution:
        Max possible profit: 171
        Number of promising nodes: 34
        Number of non-promising nodes: 35

*/




class Node 
{
   int level;
   int income; //profit 
   int wght;
   double bound;
}

public class BFSKnapsack 
{
   static int[] income;
   static int[] wght;

   public static void main (String[] args)
   {
       int W = 16;
       income = new int[]{40, 30, 50, 10};
       wght = new int[]{2, 5, 10, 5};
       sort();

       int n = income.length;

       System.out.print("Max possible income = " + knapsack(n, income, wght, W) + "\n");;

   }

   public static int knapsack (int n, int[] p, int[] w, int W)
   {
       int prmNode =0, nprmNode =0;

       //queue_of_node Q
       Queue<Node> PQ = new LinkedList<Node>();
       Node u;
       Node v = new Node();
       int maxincome = 0;

       ///initialize(Q);
       PQ.isEmpty();
       v.level = -1;
       v.income = 0;
       v.wght = 0;
       v.bound = bound(v, n, p, w, W);

       //PQ.offer(v);
       PQ.add(v);

       while (!PQ.isEmpty())
       {
           v=PQ.poll();
           if(v.bound > maxincome) 
           {
              u = new Node();
               if(v.level == -1)
               {
                   u.level = 0;
               } else if(v.level != (n-1))
               {
                   u.level = v.level + 1;
               }

               u.wght = v.wght + w[u.level];
               u.income = v.income + p[u.level];

               if (u.wght <= W && u.income > maxincome) 
               {
                   maxincome = u.income;
               }

               u.bound = bound(u,n,p,w,W);

               if (u.bound > maxincome) 
               {
                   //insert(Q, u);
                   PQ.add(u);
               } 
               else
                {
                   nprmNode++;
                }

               u = new Node();

               if(v.level == -1)
               {
                   u.level = 0;
               }
               else 
               {
                   u.level = v.level + 1;
               }

               u.wght = v.wght;
               u.income = v.income;

               u.bound = bound(u, n, p, w, W);

               if (u.bound > maxincome) 
               {
                   //insert(Q, u);
                   PQ.add(u);
               }
               else 
               {
                   nprmNode++;
               }

               prmNode++;
            } 
            else
            {
               nprmNode++;
            }
       }

       //prints
       System.out.println("# of promising nodes: \n" + prmNode);
       System.out.println("# of non-promising nodes \n" + nprmNode);

       return maxincome;
   }

   public static double bound (Node u, int n, int p[], int w[], int W)
   {
       int j;
       int k;
       int wt;
       double result;

       if (u.wght >= W)
       {
           return 0;
       }
       else
       {
           result = (double)u.income;
           j = u.level+1;
           wt = u.wght;
           
            while (j < n && wt + w[j] <= W)
           {
               wt = wt + w[j];
               result = result + p[j];
               j++;
           }
           k=j;
           
           if (k < n)
           {
               result = result + (W - wt) * (p[k]/w[k]);
           }

           return result;

       }
   }

   public static void sort()
   {
       for (int i = 0; i < income.length; i++)
       {
           for (int j = 1; j < (income.length - i); j++)
           {
               int x=income[j - 1] / wght[j - 1];
               int y=income[j] / wght[j];
               if (x <=y)
               {
                   int temp = income[j - 1];
                   income[j - 1] = income[j];
                   income[j] = temp;

                   int temp1 = wght[j - 1];
                   wght[j - 1] = wght[j];
                   wght[j] = temp1;
               }
           }
       }
   }
}
