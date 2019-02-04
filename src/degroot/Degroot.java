package degroot;

import java.util.Random;

import Jama.Matrix;

public class Degroot {
	
	protected int n=28;//��ʼ״̬��
	protected double[][] w;
	protected double[][] x;
	protected Matrix W;
	protected Matrix X;
	protected int dd=0;//��������
	
	protected void setN(int a)
	{
		n=a;
	}

	
	protected void setD(int a)
	{
		dd=a;
	}
	
	/**
	 * Degroot���캯��
	 * @param a ��ʼ״̬�����Ŀ
	 */
	public Degroot(int a)
	{
		n=a;
		Random r=new Random();
		//���ó�ʼ״̬
		w=new double[n][n];
		x=new double[n][n];
		for(int i=0;i<n;i++)
			x[i][0]=r.nextInt(100);//����0-10�������
		
		//�����ڽӾ���
		double t=0;
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				{
				w[i][j]=r.nextInt(100);//����0-100��������
				t+=w[i][j];
				if(j==n-1)//��һ��
				{	
				for(int i1=0;i1<n;i1++)
					w[i][i1]/=t;
				t=0;
				}
				}
		
		W=new Matrix(w);
		X=new Matrix(x);
		
	//	X.print(0, 14);//��ӡ��ʼ״̬
		//M.print(0, 10);
	}
	
	
	/**
	 * ���㲢��ӡDegroot
	 * @param a ��������
	 */
	void calculate(int a)
	{
		dd=a;
		for(int i=0;i<dd;i++)
		{
			W=W.times(W);
		}
		
		Matrix E=W.times(X);//����״̬
		W.print(0, 10);
		E.print(0, 10);
	}
}

