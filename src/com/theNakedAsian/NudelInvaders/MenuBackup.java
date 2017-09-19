package com.theNakedAsian.NudelInvaders;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import com.theNakedAsian.NudelInvaders.Game.STATE;

public class MenuBackup extends MouseAdapter {
	
	private Game game;
	private Handler handler;
	private HUD hud;
	private Random r = new Random();
	
	public MenuBackup(Game game, Handler handler, HUD hud) {
		this.game = game;
		this.handler = handler;
		this.hud = hud;
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		if(mouseOver(mx, my, 580, 215, 200, 64)) {
			HUD.level = 1;
			HUD.score = 0;
			
			Game.gameState = STATE.Game;
			
			handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT-64, ID.Player, handler));
			for(int i = 0; i < 10; i++) {
				handler.addObject(new basicEnemy(r.nextInt(Game.WIDTH - 32), 0, ID.basicEnemy, handler));
			}
			
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	private boolean mouseOver(int x, int y, int mx, int my, int width, int height) {
		if(mx > x && mx < x + width) {
			if(my > y && my < y + height) {
				return true;
			}else return false;
		}else return false;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		Font fnt1 = new Font ("Impact", Font.PLAIN, 70);
		g.setFont(fnt1);
		g.setColor(Color.WHITE);
		g.drawString("Nudel Invaders", 270, 100);
		
		Font fnt2 = new Font ("Impact", Font.PLAIN, 30);
		g.setFont(fnt2);
		g.drawRect(380, 150, 200, 64);
		g.drawString("Play", 450, 195);
		
		g.drawRect(380, 250, 200, 64);
		g.drawString("Help", 450, 295);
		
		g.drawRect(380, 350, 200, 64);
		g.drawString("Quit", 450, 395);
	}
}
