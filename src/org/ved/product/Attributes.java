package org.ved.product;

import java.util.Scanner;

public class Attributes{
	public static void main(String [] args){
		Scanner scanIN = new Scanner(System.in);
		Scanner scanSTR = new Scanner(System.in);
		String [] temp;
                String str;
		System.out.println("No. of attributes");
		int numAtr = scanIN.nextInt();
		String [][] mainArray = new String[numAtr][];
		for(int i=0;i<numAtr;i++){
			System.out.println("Enter "+(i+1)+" Atrribute values");
			str = scanSTR.nextLine();
			temp = str.split(" ");
			mainArray[i]=new String[temp.length];		
			for(int j=0;j<temp.length;j++){
				mainArray[i][j] = temp[j];
			}
		}
		scanIN.close();
		scanSTR.close();
		int [] status = new int[numAtr];
		int index=0,attrStat;
		boolean isDone = false;
		if(numAtr == 1){
			for(int i=0;i<mainArray[0].length;i++){
				System.out.println(mainArray[0][i]);
			}
		}else{
			while(!isDone){
				if(index == (numAtr-1)){
					System.out.println(mainArray[index][status[index]]);
					if(status[index] == (mainArray[index].length-1)){
						for(int i=0;i<index;i++){
							attrStat = 1;
							for(int j=i+1;j<index;j++){
								if(status[j] != (mainArray[j].length-1)){
									attrStat = 0;
									break;
								}
							}
							if(attrStat == 1){
								if(status[i] == (mainArray[i].length-1)){
									if(i == 0){
										isDone = true;
									}else{
										status[i]=0;
									}
								}else{
									status[i]++;
								}
							}
						}
						status[index] = 0;
					}else{ 	
						status[index]++;
					}
					index = 0;
				}else{
					System.out.print(mainArray[index][status[index]]+" ");
					index++;
				}
			}
		}
	}
}
