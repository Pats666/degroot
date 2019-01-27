package degroot;

import java.util.Random;

import Jama.Matrix;

public class Degroot {
	public static void main(String a[])
	{
		Random r=new Random();
		int n=8;//初始状态数
		double[][] m=new double[n][n];
		double[][] x=new double[n][n];
		
		//设置初始状态
		for(int i=0;i<n;i++)
			x[i][0]=r.nextInt(10);//生成0-10的随机数
		
		//设置邻接矩阵
		double t=0;
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				{
				m[i][j]=r.nextInt(100);//生成0-100间的随机数
				t+=m[i][j];
				if(j==n-1)//归一化
				{	
				for(int i1=0;i1<n;i1++)
					m[i][i1]/=t;
				t=0;
				}
				}
		
		Matrix M=new Matrix(m);
		Matrix X=new Matrix(x);
		
		X.print(0, 14);//打印初始状态
		
		for(int i=0;i<0;i++)
		{
			M=M.times(M);
		}
		
		Matrix E=M.times(X);//最终状态
		M.print(0, 10);
		E.print(0, 10);


	}
}

