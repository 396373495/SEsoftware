package test1;

import java.util.Scanner;

public class Main {
	static int maze[][];
	static int stepmin;
	static int n;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("输入迷宫大小(4-10)：");
			n = sc.nextInt();
		}while(n<=3 || n>10);
		stepmin = n*n;
		maze = new int [n][n];
		System.out.println("开始输入迷宫障碍");
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<n;j++) {
				maze[i][j] = sc.nextInt();
			}
		}
		move(1,1,0);
		if(stepmin == n*n) {
			System.out.println("No solution");
		}else {
			System.out.println(stepmin);
		}
		sc.close();
	}

	private static void move(int x, int y, int count) {
		// TODO Auto-generated method stub
		if(x == n-2 && y == n-2) {
			stepmin = Math.min(count, stepmin);
		}else {
			maze[x][y]=1;
			if(y<n-1 && maze[x][y+1] == 0) {
				move(x,y+1,count+1);
			}
			if(x<n-1 && maze[x+1][y] == 0) {
				move(x+1,y,count+1);
			}
			if(x>1 && maze[x-1][y] == 0) {
				move(x-1,y,count+1);
			}
			if(y>1 && maze[x][y-1] == 0) {
				move(x,y-1,count+1);
			}
			maze[x][y]=0;
		}
	}

}