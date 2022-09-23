import java.util.Scanner;


public class MatrixMulti
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of rows and columns of the first matrix");
        int r1=sc.nextInt();
        int c1=sc.nextInt();
        System.out.println("Enter the number of rows and columns of the second matrix");
        int r2=sc.nextInt();
        int c2=sc.nextInt();
        if(c1!=r2)
        {
            System.out.println("Matrix multiplication is not possible");
            System.exit(0);
        }
        int a[][]=new int[r1][c1];
        int b[][]=new int[r2][c2];
        int c[][]=new int[r1][c2];
        System.out.println("Enter the elements of the first matrix");
        for(int i=0;i<r1;i++)
        {
            for(int j=0;j<c1;j++)
            {
                a[i][j]=sc.nextInt();
            }
        }
        System.out.println("Enter the elements of the second matrix");
        for(int i=0;i<r2;i++)
        {
            for(int j=0;j<c2;j++)
            {
                b[i][j]=sc.nextInt();
            }
        }
        System.out.println("The first matrix is");
        for(int i=0;i<r1;i++)
        {
            for(int j=0;j<c1;j++)
            {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("The second matrix is");
        for(int i=0;i<r2;i++)
        {
            for(int j=0;j<c2;j++)
            {
                System.out.print(b[i][j]+" ");
            }
            System.out.println();
        }
        for(int i=0;i<r1;i++)
        {
            Thread t=new Thread(new MatrixThread(a,b,c,i));
            t.start();
        }   
        System.out.println("The product of the two matrices is");
        for(int i=0;i<r1;i++)
        {
            for(int j=0;j<c2;j++)
            {
                System.out.print(c[i][j]+" ");
            }
            System.out.println();
        }
        sc.close();
    }
    static class MatrixThread implements Runnable
    {
        int a[][],b[][],c[][];
        int row;
        MatrixThread(int a[][],int b[][],int c[][],int row)
        {
            this.a=a;
            this.b=b;
            this.c=c;
            this.row=row;
        }
        public void run()
        {
            for(int i=0;i<b[0].length;i++)
            {
                for(int j=0;j<a[0].length;j++)
                {
                    c[row][i]+=a[row][j]*b[j][i];
                }
            }
        }
    }
}
