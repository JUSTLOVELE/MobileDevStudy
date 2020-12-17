package com.math.algorithm;

/**
 * 拉格朗日插值
 * @author Administrator
 *
 */
public class LagrangeInterpolation {

	public static void main(String[] args) {
         
		 double X[]={1,2,3,4,5,6,7,8,9,10};
	     double Y[]={7,14,28,60,180,360,540,720,900,1080};
	     double X0[]={16};
	     double[] result = LagMethod(Y, X, X0);
	     
	     for(double d : result){
	    	   System.out.println(d);
	      }
    }
	
	/**
	 * lagrange interpolation
	 * @param X
	 * @param Y
	 * @param X0
	 * @return
	 */
    private static double[] LagMethod(double X[],double Y[],double X0[]){
        int m=X.length;
        int n=X0.length;
        double Y0[]=new double[n];
        for(int i1=0;i1<n;i1++){
            double t=0;
            for(int i2=0;i2<m;i2++){
                double u=1;
                for(int i3=0;i3<m;i3++){
                    if(i2!=i3){
                        u=u*(X0[i1]-X[i3])/(X[i2]-X[i3]);
                    }
                }
                u=u*Y[i2];
                t=t+u;
            }
            Y0[i1]=t;
        }
         
        return Y0; 
         
    }
}
