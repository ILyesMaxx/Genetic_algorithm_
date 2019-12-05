package DeffrentEvo;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MainEv {
    public static int ROWS=10;
    public static int COLUMN=5;
    public static  float  F= (float)Math.random();
    public static float C=(float)Math.random();
    ;

    public static void main(String[]args){
        float[][] initializatedMat=initialization();

        for (int t=0;t<50;t++){
            float[][] mutatedMat=mutation(initializatedMat);
            System.out.println("////////////");
            initializatedMat=cross_over(initializatedMat,mutatedMat);

        }





    }
    public static float[][] initialization(){
        float [] [] matTmp=new float[ROWS][COLUMN];
        for (int i=0;i<ROWS;i++){
            for (int j=0;j<COLUMN;j++){
                float random = (float)(100.0 * Math.random());

                matTmp[i][j]=random;
            }
        }
        return matTmp;
    }
    public static float[][] mutation( float [] [] mat){
        float [] [] matTmp=new float[ROWS][COLUMN];
        for (int i=0;i<ROWS;i++){
            Random r = new Random();
            int ind1,ind2,ind3 ;
            while ((ind1=r.nextInt(ROWS-0) + 0)==i){
            }
            while ((ind2=r.nextInt(ROWS-0) + 0)==i){
            }
            while ((ind3=r.nextInt(ROWS-0) + 0)==i){
            }
            for (int j=0;j<COLUMN;j++){
                matTmp [i][j]=mat[ind1][j]+ Math.abs(F*(mat[ind2][j]-mat[ind3][j]));
            }
        }
        return matTmp;
    }
    public static float[][] cross_over(float [] [] original,float [] [] mutated){
        float parent1[]=new float[COLUMN];
        float parent2[]=new float[COLUMN];
        float fils1[]=new float[COLUMN];
        float fils2[]=new float[COLUMN];
        float choosen[]=new float[COLUMN];
        float [] [] matTmp=new float[ROWS][COLUMN];


        for (int i=0;i<ROWS;i++){
            float ratio=(float)Math.random();
            if (ratio<C){
                parent1=original[i];
                parent2=mutated[i];
                for (int j=0;j<=(COLUMN/2)-1;j++){
                    fils1[j]=parent1[j];
                    fils2[j]=parent2[j];
                }
                for (int j=(COLUMN/2);j<=COLUMN-1;j++){
                    fils1[j]=parent2[j];
                    fils2[j]=parent1[j];
                }
                float v1=0;
                float v2=0;
                float v3=0;
                for (int k=0;k<COLUMN;k++){
                    v1=v1+(fils1[k]*fils1[k]);
                    v2=v2+(fils2[k]*fils2[k]);
                    v3=v3+(parent1[k]*parent1[k]);
                }
                if (v1<v2 && v1<v3 ){
                    choosen=fils1;
                }else if (v2< v1 && v2 <v3){
                    choosen=fils2;

                }else {
                    choosen=parent1;

                }
                for (int k=0;k<COLUMN;k++){
                    System.out.print(choosen[k]+" ");
                }
                System.out.println();
            }else {
                float v1=0;
                float v2=0;
                for (int k=0;k<COLUMN;k++){
                    v1=v1+(parent1[k]*parent1[k]);
                    v2=v2+(parent2[k]*parent2[k]);
                }
                if (v1<v2){
                    choosen=parent1;
                }else {
                    choosen=parent2;
                }
                for (int k=0;k<COLUMN;k++){
                    System.out.print(choosen[k]+" ");
                }
                System.out.println();
            }
            matTmp[i]=choosen;

        }
        return matTmp;
    }

}
