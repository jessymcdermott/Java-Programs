/*
Jessy McDermott
CIS 360
Homework 8 n-queens
*/
//OUTPUTS AT BOTTOM
public static void main(Srtring[] args)
{
    /*
    hardcode or create a statement to take in the amount
    of queens from the user?
    */
    int queens; 
    int[] board = new int[queens + 1];

    queens(board, queens, 0);
}

public static viod queens(int[] board, int i, int j)
{
    int k;

    if(promise(board, j))
    {
        if(j == i)
        {
            System.out.print("Solution: ");

            for(k = 1; k <= i; k++)
            {
                System.out.print("Board[" + k + "] = " + board[k] + " ");
            }
            System.out.printLn(" ");
        }
        else
        {
            for(k = 1; k <= i; k++)
            {
                board[j + 1] = k;
                queens(board, i, j + 1));
            }
        }
    }
}

public static boolean promise(int[] board, int j)
{
    int l = 1;
    boolean incoming = true

    while(l < j && incoming)
    {
        if(board[j] == board[l] || abs(board[j] - board[l]) == (j - l))
        {
            incoming = false;
        }
        l++;
    }
    return incoming;
}

/*

n= 4
col[1] = 2
col[2] = 4
col[3] = 1
col[4] = 4
possible sol: 1
total sol: 2
total pruned nodes: 44

n= 8
col[1] = 1
col[2] = 5
col[3] = 8
col[4] = 6
col[5] = 3
col[6] = 7
col[7] = 2
col[8] = 4
possible sol: 1
total sol: 92
total pruned nodes: 13664

n=10
col[1] = 1
col[2] = 3 col[3] = 6 col[4] = 8 col[5] = 10
col[6] = 5
col[7] = 9
col[8] = 2
col[9] = 4
col[10] = 7
possible sol: 1
total sol: 724
total pruned nodes: 312612

n=12
col[1] = 1
col[2] = 3
col[3] = 5
col[4] = 8
col[5] = 10
col[6] = 12
col[7] = 6
col[8] = 11
col[9] = 2
col[10] = 7
col[11] = 9
col[12] = 4
possible sol: 1
total sol: 14200
total pruned nodes: 9247680

*/