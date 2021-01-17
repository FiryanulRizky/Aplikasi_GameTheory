/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameTheory;

public class pureSTR {
    
    //inisiasi
    float [][] s = new float[3][3];     //array data
    float [] mini = new float[3];       //array nilai minimal
    float [] maxi = new float[3];       //array nilai maksimal
    float maksimin, minimax,spa,spb;
    int sa,sb;  //simpan strategi
    
    pureSTR(float [][] data){
        
        s = data;   //penyimpanan data
        
    }
    
    void count_min(){
        
        for(int i=0; i<3; i++){
            float min=9999;
            for(int j=0; j<3; j++){
                if(min > s[i][j] && s[i][j] != 0){  //pencarian nilai minimal
                    min = s[i][j];
                }
            }
            mini[i] = min;
        }
        
    }
    
    void count_max(){
        
        for(int i=0; i<3; i++){
            float max=0;
            for(int j=0; j<3; j++){
                if(max < s[j][i]){      //pencarian nilai maksimal
                    max = s[j][i];
                }
            }
            maxi[i] = max;
        }
        
    }
    
    void find_maximin(){
        
        maksimin = 0;
        for(int i=0; i<3; i++){
            if(maksimin < mini[i]){
                maksimin = mini[i];     //pencarian nilai maksimin
                sa = i+1;               //menyimpan strategi maksimin
            }
        }
        spa = maksimin;         //saddle point a
        
    }
    
    void find_minimax(){
        
        minimax = 9999;
        for(int i=0; i<3; i++){
            if(minimax > maxi[i]){
                minimax = maxi[i];      //pencarian nilai minimax
                sb = i+1;               //menyimpan strategi minimax
            }
        }
        spb = minimax;          //saddle point b
        
    }
    
}
