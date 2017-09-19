package com.theNakedAsian.NudelInvaders;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class HUD {
	
	public static int HEALTH = 3;
	public static int health1 = 32;
	public static int health2 = 32;
	public static int health3 = 32;
	
	public static int score = 0;
	public static int level = 1;

	public void tick() {
	}

	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(15, 15, 102, 32);
		
		g.setColor(Color.green);
		g.fillRect(15, 15, health1, 32);
		g.fillRect(50, 15, health2, 32);
		g.fillRect(85, 15, health3, 32);
		
		g.setColor(Color.WHITE);
		g.drawRect(15, 15, 32, 32);
		g.drawRect(50, 15, 32, 32);
		g.drawRect(85, 15, 32, 32);
		
		Font fnt1 = new Font ("Implact", Font.PLAIN, 24);
		g.setFont(fnt1);
		g.drawString("Score: " + score, 15, 70);
		g.drawString("Level:" + level, 15, 100);
	}

	public static int getScore() {
		return score;
	}

	public static void setScore(int score) {
		HUD.score = score;
	}

	public static int getLevel() {
		return level;
	}

	public static void setLevel(int level) {
		HUD.level = level;
	}

	public static int getHealth1() {
		return health1;
	}

	public static void setHealth1(int health1) {
		HUD.health1 = health1;
	}

	public static int getHealth2() {
		return health2;
	}

	public static void setHealth2(int health2) {
		HUD.health2 = health2;
	}

	public static int getHealth3() {
		return health3;
	}

	public static void setHealth3(int health3) {
		HUD.health3 = health3;
	}
	
}



	