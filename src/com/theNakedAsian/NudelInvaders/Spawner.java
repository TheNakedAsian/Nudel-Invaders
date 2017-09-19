package com.theNakedAsian.NudelInvaders;

import java.util.Random;

public class Spawner {
	
	private Handler handler;
	private HUD hud;
	private Random r = new Random();
	private int waveClearTime = 0;
	
	public Spawner(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
	}
	
	public void tick() {
		waveClearTime ++;
		
		if(Menu.enemy_removed == Menu.enemy_count) {
			HUD.setLevel(HUD.getLevel() + 1);
			Menu.enemy_count +=1;
			Menu.enemy_removed = 0;
			waveClearTime = 0;
		}
		if(HUD.level == 2 && waveClearTime == 0 ) {
			for(int i = 0; i < Menu.enemy_count; i++) {
				handler.addObject(new basicEnemy(r.nextInt(Game.WIDTH - 32), 0, ID.basicEnemy, handler));
			}
		}
		if(HUD.level == 3 && waveClearTime == 0 ) {
			for(int i = 0; i < Menu.enemy_count; i++) {
				handler.addObject(new basicEnemy(r.nextInt(Game.WIDTH - 32), 0, ID.basicEnemy, handler));
			}
		}
		if(HUD.level == 4 && waveClearTime == 0 ) {
			for(int i = 0; i < Menu.enemy_count; i++) {
				handler.addObject(new basicEnemy(r.nextInt(Game.WIDTH - 32), 0, ID.basicEnemy, handler));
			}
		}
		if(HUD.level == 5 && waveClearTime == 0 ) {
			for(int i = 0; i < Menu.enemy_count; i++) {
				handler.addObject(new basicEnemy(r.nextInt(Game.WIDTH - 32), 0, ID.basicEnemy, handler));
			}
		}
		if(HUD.level == 6 && waveClearTime == 0 ) {
			for(int i = 0; i < Menu.enemy_count; i++) {
				handler.addObject(new basicEnemy(r.nextInt(Game.WIDTH - 32), 0, ID.basicEnemy, handler));
			}
		}
		if(HUD.level == 7 && waveClearTime == 0 ) {
			for(int i = 0; i < Menu.enemy_count; i++) {
				handler.addObject(new basicEnemy(r.nextInt(Game.WIDTH - 32), 0, ID.basicEnemy, handler));
			}
		}
		if(HUD.level == 8 && waveClearTime == 0 ) {
			for(int i = 0; i < Menu.enemy_count; i++) {
				handler.addObject(new basicEnemy(r.nextInt(Game.WIDTH - 32), 0, ID.basicEnemy, handler));
			}
		}
		if(HUD.level == 9 && waveClearTime == 0 ) {
			for(int i = 0; i < Menu.enemy_count; i++) {
				handler.addObject(new basicEnemy(r.nextInt(Game.WIDTH - 32), 0, ID.basicEnemy, handler));
			}
		}
		if(HUD.level == 10 && waveClearTime == 0 ) {
			for(int i = 0; i < Menu.enemy_count; i++) {
				handler.addObject(new basicEnemy(r.nextInt(Game.WIDTH - 32), 0, ID.basicEnemy, handler));
			}
		}
	}
}
