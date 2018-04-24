package com.day03;

public class LetterPrint {

	private enum Letter{
		A,
		B,
		C,
		D,
		E,
		F, 
		G, 
		H,
		I, 
		J, 
		K,
		L,
		M,
		N,
		O, 
		P,
		Q, 
		R, 
		S, 
		T, 
		U, 
		V,
		W, 
		X, 
		Y,
		Z
	}
	
	private Letter l;
	public LetterPrint(Letter a){
		this.l = a;
	}
	
	public void printLetter(){
		switch( this.l.ordinal()){
		case 0:
			printA();
			break;
		case 1:
			printB();
			break;
		case 2:
			printC();
			break;
		case 3:
			printD();
			break;
		case 4:
			printE();
			break;
		case 5:
			printF();
			break;
		case 6:
			printG();
			break;
		case 7:
			printH();
			break;
		case 8:
			printI();
			break;
		case 9:
			printJ();
			break;
		case 10:
			printK();
			break;
		case 11:
			printL();
			break;
		case 12:
			printM();
			break;
		case 13:
			printN();
			break;
		case 14:
			printO();
			break;
		case 15:
			printP();
			break;
		case 16:
			printQ();
			break;
		case 17:
			printR();
			break;
		case 18:
			printS();
			break;
		case 19:
			printT();
			break;
		case 20:
			printU();
			break;
		case 21:
			printV();
			break;
		case 22:
			printW();
			break;
		case 23:
			printX();
			break;
		case 24:
			printY();
			break;
		case 25:
			printZ();
			break;
		}
	}
	private void printA(){
		int lim = 5;
		int mid = lim/2; //limit divided by 2 is in middle
		for(int i = 0; i < lim; i++){
			for(int j = 0; j < lim - i-1; j++)
				System.out.print(" ");
			
			for(int j = 0; j < 2 * i+1; j++){
				if( i == mid){
					System.out.print("*");
				}else{
					if( j == 0 || j == 2 * i)
						System.out.print("*");
					else
						System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	private void printB(){
		int lim = 5;
		int mid = lim/2;
		for(int i =0; i < lim; i++){
			for(int j = 0; j < lim ;j++){
				if( j == 0)
					System.out.print("*");
				else{
					if( (i % mid)== 0 && (j < lim-1))
						System.out.print("*");
					else{
						if( (i % mid) != 0 && j == lim-1)
							System.out.print("*");
						else
							System.out.print(" ");
					}
				}
			}
			System.out.println();
		}
	}
	private void printC(){
		int lim = 5;
		int mid = lim/2;
		for(int i =0 ; i < lim; i++){
			if( i <= mid){
				for(int j = 0; j < mid-i;j++)
					System.out.print(" ");
			}else{
				for(int j = 0; j < i - mid; j++)
					System.out.print(" ");
			}
			
			if( i == 0 || i == lim-1){
				for(int j = 0; j < lim; j++)
					System.out.print("*");
			}else{
				System.out.print("*");
			}
			
			System.out.println();
		}
	}
	
	private void printD(){
		int lim = 5;
		int mid = lim/2;
		for(int i = 0 ;i < lim; i++){
			if( i== 0 || i == lim-1){
				for(int j = 0; j < lim-3;j++)
					System.out.print("*");
				System.out.println();
			}else{
				System.out.print("*");
				//print space
				if( i < mid){
					for(int j = 0; j < mid-i;j++)
						System.out.print(" ");
				}else if ( i > mid){
					for(int j = 0; j < i-mid; j++)
						System.out.print(" ");
				}else{
					for(int j =0 ; j < mid; j++)
						System.out.print(" ");
				}
				
				System.out.println("*");
			}
		}
	}
	
	private void printE(){
		int lim = 5;
		int mid = lim/2;
		for(int i =0 ; i < lim; i++){
			if( i %mid == 0){
				for(int j =0; j < lim;j++)
					System.out.print("*");
			}else
				System.out.print("*");
			System.out.println();
		}
	}
	
	private void printF(){
		int lim = 5;
		int mid = lim/2;
		for(int i = 0; i < lim; i++){
			System.out.print("*");
			if( i == 0){
				for(int j = 0; j < lim-1; j++)
					System.out.print("*");
			}else if( i == mid){
				for(int j = 0; j < lim -2; j++)
					System.out.print("*");
			}
			System.out.println();
		}
	}
	
	private void printG(){
		int lim = 5;
		int mid = lim/2;
		for(int i = 0; i < lim ; i++){
			for(int j = 0 ; j < lim; j++){
				if( i == 0 || i == lim-1)
					System.out.print("*");
				else if ( i == mid){
					if( j == 0 || j > 1)
						System.out.print("*");
					else
						System.out.print(" ");
				}
				else if ( i > mid){
					if( j == 0 || j == lim-1)
						System.out.print("*");
					else
						System.out.print(" ");
				}else{
					if( j == 0)
						System.out.print("*");
				}
			}
			System.out.println();
		}
	}
	
	private void printH(){
		int lim = 5;
		int mid = lim/2;
		for(int i = 0; i < lim; i++){
			for(int j = 0; j < lim; j++){
				if( i == mid){
					System.out.print("*");
				}else{
					if( j == 0 || j == lim-1){
						System.out.print("*");
					}else
						System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	private void printI(){
		int lim = 5;
		int mid = lim/2;
		for(int i = 0 ; i < lim ; i++){
			if( i == 0 || i == lim-1){
				for(int j = 0; j < lim ; j++)
					System.out.print("*");
			}else{
				for(int j = 0; j < mid ; j++)
					System.out.print(" ");
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	private void printJ(){
		int lim = 5;
		int mid = lim/2;
		for(int i = 0; i < lim; i++){
			if( i == 0){
				for(int j = 0; j < lim; j++)
					System.out.print("*");
			}else if( i < mid){
				for(int j = 0; j < mid; j++)
					System.out.print(" ");
				System.out.print("*");
			}else if (i >= mid && i != lim-1){
				System.out.print("*");
				for(int j = 0 ; j < mid-1; j++)
					System.out.print(" ");
				System.out.print("*");
				
			}else{
				for(int j =0 ;j <= mid; j++)
					System.out.print("*");
			}
			
			System.out.println();
		}
	}
	
	private void printK(){
		int lim = 5;
		int mid = lim/2;
		int end = lim-1;
		for(int i = 0; i < lim; i++){
			for(int j = 0; j < lim; j++){
				if( j == 0 || ( i <= mid && end - (i+j) == 0) ||
						(i > mid && i==j))
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	private void printL(){
		int lim = 5;
		for(int i = 0; i < lim; i++){
			System.out.print("*");
			if( i == lim-1){
				for(int j = 0; j < lim-1;j++)
					System.out.print("*");
			}
			System.out.println();
		}
	}
	private void printM(){
		int lim = 5;
		int end = 2 * lim +1;
		int mid = lim /2;
		for(int i=0; i < lim; i++){
			for(int j = 0; j < end; j++){
				if( j == 0 || j == end-1 || j-i == mid-2 || (i+j) == end-1)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
		
	}
	private void printN(){
		int lim = 5;
		int mid = lim/2;
		int end = 2 * lim + 1;
		for(int i = 0; i < lim; i++){
			for(int j = 0; j < end;j++){
				if( j == 0 || j == end/2-1  || (j-i) == mid-2)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}
	private void printO(){
		int lim = 5;
		for(int i = 0; i < lim;i++){
			System.out.print("*");
			for(int j = 0; j < lim -1; j++){
				if( i == 0 || i == lim -1)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println("*");
		}
	}
	
	private void printP(){
		int lim = 5;
		int mid = lim / 2;
		for(int i = 0; i < lim ; i++){
			System.out.print("*");
			if( i <= mid){
				if( i == 0 || i == mid){
					for(int j = 0 ; j < lim -2; j++){
						System.out.print("*");
					}
				}else{
					for(int j = 0 ; j < lim -2; j++)
						System.out.print(" ");
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
	private void printQ(){
		int lim = 5;
		int mid = lim/2; //limit
		for(int i = 0; i < lim; i++){
			System.out.print("*");
			if( i == 0 || i == lim -1){
				for(int j = 0; j < lim; j++)
					System.out.print("*");
				if( i == lim -1)
					System.out.print("*");
			}
			else{
				for(int j = 0; j < lim; j++){
					if( i >= mid && i == j)
						System.out.print("*");
					else if( j < lim-1)
						System.out.print(" ");
				}
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	private void printR(){
		int lim = 5;
		int mid = lim / 2;
		for(int i = 0; i < lim ; i++){
			System.out.print("*");
			if( i <= mid){
				if( i == 0 || i == mid){
					for(int j = 0 ; j < lim -2; j++){
						System.out.print("*");
					}
				}else{
					for(int j = 0 ; j < lim -2; j++)
						System.out.print(" ");
					System.out.print("*");
				}
			}else{
				for(int j = 0; j <= i-mid; j++){
					if ( j == i-mid)
						System.out.print("*");
					else
						System.out.print(" ");
				}
				
			}
			System.out.println();
		}
	}
	private void printS(){
		int lim = 5;
		int mid = lim/2;
		for(int i = 0; i < lim ; i++){
			if( i % mid == 0){
				for(int j = 0; j < lim ; j++)
					System.out.print("*");
			}else if ( i < mid){
				System.out.print("*");
			}else{
				for(int j = 0 ; j < lim -1;j++)
					System.out.print(" ");
				System.out.print("*");
			}
			System.out.println();
		}
	}
	private void printT(){
		int lim = 5;
		int mid = lim /2;
		for(int i = 0; i < lim;i++){
			if( i == 0){
				for(int j = 0; j < lim; j++)
					System.out.print("*");
			}else{
				for(int j = 0; j < mid; j++)
					System.out.print(" ");
				System.out.print("*");
			}
			System.out.println();
		}
	}
	private void printU(){
		int lim = 5;
		int mid = lim /2;
		for(int i = 0; i < lim;i++){
			if( i != lim-1){
				for(int j = 0; j < lim; j++){
					if( j == 0 || j == lim-1)
						System.out.print("*");
					else
						System.out.print(" ");
				}
			}else{
				for(int j = 0; j < lim; j++){
					if( j == 0 || j == lim-1)
						System.out.print(" ");
					else
						System.out.print("*");
				}
				
			}
			System.out.println();
		}
	}
	private void printV(){
		int lim = 5;
		int end = 2 * lim ;
		int mid = end /2;
		for(int i = 0; i < lim ; i++){
			for(int j = 0 ;j < end ; j++){
				if( i == j || j == end-i-1)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}
	private void printW(){
		int lim = 5;
		int end = 2 * lim +1;
		int mid = end /2 ;
		for(int i=0; i < lim; i++){
			for(int j = 0; j < end; j++){
				if( j == 0 || j == end-1 || (i+j) == mid || (j-i) == mid-1)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}
	private void printX(){
		int lim = 5;
		int end = lim-1;
		for(int i = 0; i < lim; i++){
			for(int j = 0; j < lim;j++){
				if( i==j || (j+i) == end)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}
	private void printY(){
		int lim = 5;
		int end = lim-1;
		int mid = lim/2;
		for(int i = 0; i < lim; i++){
			if( i <= mid){
				for(int j = 0; j < lim;j++){
					if( i==j || (j+i) == end)
						System.out.print("*");
					else
						System.out.print(" ");
				}
			}else{
				for(int j = 0; j < mid; j++)
					System.out.print(" ");
				System.out.print("*");
			}
			System.out.println();
		}
	}
	private void printZ(){
		int lim = 5;
		int end = lim-1;
		for(int i = 0; i < lim;i++){
			if( i == 0 || i == lim-1){
				for(int j = 0; j < lim; j++)
					System.out.print("*");
			}else{
				for(int j = 0; j < lim;j++){
					if( j+i == end)
						System.out.print("*");
					else
						System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LetterPrint lp = new LetterPrint(LetterPrint.Letter.O);
		lp.printLetter();
	}
}

