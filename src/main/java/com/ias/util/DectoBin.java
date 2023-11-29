package com.ias.util;

public class DectoBin {
public static void main(String[] args) {
	System.out.println(Integer.toBinaryString(4));
	
	long x = 2, n1;
	long rev =0;
	n1=x;
	while(n1>0) {
		rev <<=1;
		System.out.println(rev);
		if((n1 & 1)==1)
			rev ^=1;
		    n1>>=1;
	
	}
	System.out.println(x +" "+ rev);
}
}
