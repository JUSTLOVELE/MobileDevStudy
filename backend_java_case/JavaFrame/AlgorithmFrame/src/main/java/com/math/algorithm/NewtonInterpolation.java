package com.math.algorithm;


/**
 * Newton Interpolation
 * @author Administrator
 *
 */
public class NewtonInterpolation {
	
	 public static void main(String[] args) {
	         
		   double X[]={1,2,3,4,5,6,7,8,9,10};
	       double Y[]={7,14,28,60,180,360,540,720,900,1080};
	       double X0[]={16};
	       
	       double[] result = NewtonInterMethod(Y, X, X0);
	       
	       for(double d : result){
	    	   System.out.println(d);
	       }
	 
	    }
     
    /**
     *  Newton Interpolation
     * @param X
     * @param Y
     * @param X0
     * @return
     */
    public static double[] NewtonInterMethod(double[] X,double[] Y,double X0[]){
        int m=X.length;
        int n=X0.length;
        double[] Y0=new double[n];
        double[] cp_Y=new double[m];
        for(int i1=0;i1<n;i1++){
            double t=0;
            int j=0;
            copyVector(Y, cp_Y);
            int kk=j;
            
            while(kk<m-1){
                kk=kk+1;
                for(int i2=kk;i2<m;i2++){
                    cp_Y[i2]=(cp_Y[i2]-cp_Y[kk-1])/(X[i2]-X[kk-1]);
                }
            }
            
            double temp=cp_Y[0];
            for(int i=1;i<=m-1;i++){
                double u=1;
                int jj=0;
                while(jj<i){
                    u*=(X0[i1]-X[jj]);
                    jj++;
                }
                temp+=cp_Y[i]*u;
            }
             
            Y0[i1]=temp;
        }
         
        return Y0;
    }
    
    private static void copyVector(double from[],double to[]){
        int k=from.length;
        int k2=to.length;
        if(k!=k2){
            System.out.println("the two vector's length is not equal!");
            System.exit(0);
        }
        for(int i=0;i<k;i++){
            to[i]=from[i];
        }
         
    }
     
}
