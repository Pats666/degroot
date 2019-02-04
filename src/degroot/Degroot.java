package degroot;

import java.util.Random;

import Jama.Matrix;

public class Degroot {
	
	protected int n=28;//初始状态数
	protected double[][] w;
	protected double[][] x;
	protected Matrix W;
	protected Matrix X;
	protected int dd=0;//迭代次数
	
	protected void setN(int a)
	{
		n=a;
	}

	
	protected void setD(int a)
	{
		dd=a;
	}
	
	/**
	 * Degroot构造函数
	 * @param a 初始状态结点数目
	 */
	public Degroot(int a)
	{
		n=a;
		Random r=new Random();
		//设置初始状态
		w=new double[n][n];
		x=new double[n][n];
		for(int i=0;i<n;i++)
			x[i][0]=r.nextInt(100);//生成0-10的随机数
		
		//设置邻接矩阵
		double t=0;
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				{
				w[i][j]=r.nextInt(100);//生成0-100间的随机数
				t+=w[i][j];
				if(j==n-1)//归一化
				{	
				for(int i1=0;i1<n;i1++)
					w[i][i1]/=t;
				t=0;
				}
				}
		
		W=new Matrix(w);
		X=new Matrix(x);
		
	//	X.print(0, 14);//打印初始状态
		//M.print(0, 10);
	}
	
	
	/**
	 * 计算并打印Degroot
	 * @param a 迭代次数
	 */
	void calculate(int a)
	{
		dd=a;
		for(int i=0;i<dd;i++)
		{
			W=W.times(W);
		}
		
		Matrix E=W.times(X);//最终状态
		W.print(0, 10);
		E.print(0, 10);
	}
}

