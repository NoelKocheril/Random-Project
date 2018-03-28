package practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Caesar {

	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner in = new Scanner(System.in);
		char [] test = new char[50];
		//		test = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("C://Users//noelk//eclipse-workspace//Test//Random-Project//src//practice//input.txt")));

		Caesar CC = new Caesar();
		//		char [] out = CC.Cipher(test, 4);
		//		char [] re_in = CC.Decipher(out, 4);
		//		for(char e:out) {
		//			System.out.print(e);
		//		}
		//		System.out.println();
		//
		//		for(char e:re_in) {
		//			System.out.print(e);
		//		}
		//		System.out.println();
		//		
		while(reader.read(test) != -1) {
			System.out.print("Input: \t\t");
			for(char e: test) {
				System.out.print(e);
			}
			System.out.println();
			System.out.print("Cipher: \t");
			for(char e: test) {
				System.out.print(CC.Cshift(e, 3));
			}
			//			TimeUnit.SECONDS.sleep(1);
			System.out.println();
			System.out.print("Decipher: \t");
			for(char e: test) {
				System.out.print(CC.Dshift(e, 3));
			}
			System.out.println("\n");
			TimeUnit.SECONDS.sleep(1);
		}
		reader.close();
		in.close();

	}

	char[] Cipher(char [] word, int shift) {
		char[] out = new char[word.length];
		for(int i = 0; i < word.length;i++) {
			out[i] = Cshift(word[i], shift%26);
		}
		return out;
	}

	char[] Decipher(char [] word, int shift) {
		char[] out = new char[word.length];
		for(int i = 0; i < word.length;i++) {
			out[i] = Dshift(word[i], shift%26);
		}
		return out;
	}

	char Cshift(char c, int s) {
		if(((int)(c) >= 65) && ((int)(c) <= 90)) {
			if((c+s)>90) {
				s = (c+s)%91;
				c = 'A';
			}
			return (char)(c+s);
		} else if(((int)(c) >= 97) && ((int)(c) <= 122)){
			if((c+s)>122) {
				s = (c+s)%123;
				c = 'a';
			}
			return (char)(c+s);
		} else {
			return c;
		}
	}

	char Dshift(char c, int s) {
		if(((int)(c) >= 65) && ((int)(c) <= 90)) {
			if((c-s)<65) {
				s = Math.abs(c-s-64);
				c = 'Z';
			}
			return (char)(c-s);
		} else if(((int)(c) >= 97) && ((int)(c) <= 122)){
			if((c-s)<97) {
				s = Math.abs(c-s-96);
				c = 'z';
			}
			return (char)(c-s);
		} else {
			return c;
		}
	}
}
