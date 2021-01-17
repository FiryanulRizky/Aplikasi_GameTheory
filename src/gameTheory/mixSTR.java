/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameTheory;

/**
 *
 * @author Rasito7659
 */
public class mixSTR {
    
    //inisiasi
    float [][] s = new float[3][3]; //array data
    float [][] snew = new float[2][2];  //array data baru setelah mengurangi
    float p,q,x,y,spa,spb;
    int [] cursorx = new int[2];    //array simpan strategi a
    int [] cursory = new int[2];    //array simpan startegi b
    
    mixSTR(float [][] data,float [] mini, float [] maxi){
        
        s = data; //menyimpan data
        float minout=9999,maxout=0;
        int out1 = 0,out2 = 0;
        
        for(int i=0; i<3; i++){
            //mencari nilai pembuat keuntungan terkecil
            if(minout > mini[i]){
                minout = mini[i];
                out1 = i;
            }
            //mencari nilai pembuat kerugian terbesar
            if(maxout < maxi[i]){
                maxout = maxi[i];
                out2 = i;
            }
        }
        
        int a=0,b=0;
        //penyimpanan nilai startegi sebelum pembuatan array baru
        for(int i=0;i<3;i++){
            if(i!=out1){
                cursorx[a] = i;
                a++;
            }
            if(i!=out2){
                cursory[b] = i;
                b++;
            }
        }
        
        //pengenolan nilai data dominan
        for(int i=0; i<3; i++){
            s[out1][i] = 0;
            s[i][out2] = 0;
        }
        
        a=0;
        for(int i=0; i<3; i++){
            b=0;
            for(int j=0; j<3; j++){
                if(s[i][j]!=0){
                    snew[a][b] = s[i][j];       //pembuatan array baru
                    b++;
                }
            }
            if(b!=0){
                a++;
            }
        }
        /*
        System.out.println();
        for(int i=0; i<2; i++){
            for(int j=0; j<2; j++){
                System.out.print(snew[i][j]+" ");
            }
            System.out.println();
        }
        */
    }
    
    void spObjectA(){
        
        x = 0;
        y = 0;
        
        x = snew[0][0] - snew[1][0];    //menyimpan variable p persamaa(1)
        y = snew[0][1] - snew[1][1];    //menyimpan variable p persamaa(2)
        
        p = (snew[1][0] - snew[1][1])/(y-x);    //peluang p
        
        spa = (snew[0][0]*p)+(snew[1][0]*(1-p)); //nilai saddle point a
        
    }
    
    void spObjectB(){
        
        x = 0;
        y = 0;
        
        x = snew[0][0] - snew[0][1];    //menyimpan variable q persamaa(1)
        y = snew[1][0] - snew[1][1];    //menyimpan variable q persamaa(2)
                
        q = (snew[0][1] - snew[1][1])/(y-x);    //peluang q
        
        spb = (snew[0][0]*q)+(snew[0][1]*(1-q)); //saddle point b
        
    }
    
}
