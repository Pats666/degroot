package fj;

import Jama.Matrix;
import degroot.Degroot;

public class FJ extends Degroot{

	protected double[][] ii;
	protected double[][] d;
	protected Matrix D;//对角矩阵
	protected Matrix I;//单位矩阵
	
	/**
	 * FJ构造函数
	 * @param a 初始状态数
	 */
	FJ(int a) {
		super(a);
		// TODO 自动生成的构造函数存根
		d=new double[n][n];
		ii=new double[n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				{
				if(i==j)
					{
					d[i][j]=0.1;
					ii[i][j]=1;
					}
				else
					{
					d[i][j]=0;
					ii[i][j]=0;
					}
				}
		D=new Matrix(d);
		I=new Matrix(ii);
	}
	
	Matrix r(int i,Matrix m)
	{
		if(i==0)
			return m;
		else
		{
			Matrix x0,x1;
			x0=D.times(W).times(r(i-1,m));
			x1=I.minus(D).times(X);
			return x0.plus(x1);
		}
	}
	/**
	 * 计算并打印FJ
	 * @param a 迭代次数
	 */
	void calculate(int a)
	{
	    setD(a);
	    r(dd,X).print(0, 5);
	}
	
	public static void main(String aa[])
	{
		FJ a=new FJ(8);
		for(int i=0;i<5;i++)
		a.calculate(i);		
	}

}
