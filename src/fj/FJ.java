package fj;

import Jama.Matrix;
import degroot.Degroot;

public class FJ extends Degroot{

	protected double[][] ii;
	protected double[][] d;
	protected Matrix D;//�ԽǾ���
	protected Matrix I;//��λ����
	
	/**
	 * FJ���캯��
	 * @param a ��ʼ״̬��
	 */
	FJ(int a) {
		super(a);
		// TODO �Զ����ɵĹ��캯�����
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
	 * ���㲢��ӡFJ
	 * @param a ��������
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
