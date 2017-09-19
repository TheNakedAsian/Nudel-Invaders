package com.theNakedAsian.NudelInvaders;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet extends GameObject{
	
	Handler handler;
	
	public Bullet(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 8, 8);
	}
	
	public void tick() {	
		x += velX;
		y += velY;
		
		velY = -7 ;
		
		if(y <= 0 || y >= Game.HEIGHT)
			handler.removeObject(this);
		
		
		collision();
	}
	
	private void collision() {
		for (int i = 0; i < handler.object.size(); i++) {
			
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.basicEnemy ) {
				if(getBounds().intersects(tempObject.getBounds())) {
					handler.removeObject(this);
					handler.removeObject(tempObject);
					
					Menu.enemy_removed +=1;
					HUD.score += 10;
				}
			}
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillOval(x, y, 8, 8);
	}

}
