package com.theNakedAsian.NudelInvaders;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class basicEnemy extends GameObject{
	
	Handler handler;
	private Random r = new Random(); 
	private int speedY = r.nextInt(2) + 1;
	
	private BufferedImage b_enemy_image;
	
	public basicEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		SpriteSheet ss = new SpriteSheet(Game.Sprite_Sheet);
		
		b_enemy_image = ss.grabImage(1, 2, 32, 32);
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}
	
	public void tick() {	
		x += velX;
		y += velY;
		
		velX = r.nextInt(10) - 5;
		velY = speedY;
		
		if(y >= Game.HEIGHT - 32) {
			handler.removeObject(this);
			Menu.enemy_removed +=1;
			if(HUD.health3 > 0)
				HUD.health3 = 0;
			else if(HUD.health3 == 0 && HUD.health2 > 0)
				HUD.health2 = 0;
			else if(HUD.health3 == 0 && HUD.health2 == 0 && HUD.health1 > 0)
				HUD.health1 = 0;
			
		}
		collision();
	}
	
	private void collision() {
	}

	public void render(Graphics g) {
		//g.setColor(Color.red);
		//g.fillRect(x, y, 32, 32);
		g.drawImage(b_enemy_image, (int)x, (int)y, null);
	}

}
