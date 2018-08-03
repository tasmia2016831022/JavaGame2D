package shooot.map;

import shooot.game.Collision;
import shooot.game.SoundPlay;
import shooot.map.entity.Enemy;
import shooot.map.entity.Entity;
import shooot.map.entity.MovingEntity;
import shooot.map.entity.GunShot;
import shooot.map.entity.UserEntity;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * @author partha
 */
public abstract class Map {

    protected ArrayList<Entity> renderableEntities;

    protected ArrayList<MovingEntity> moveableEntities;
    
    protected ArrayList<Entity> entities;

    protected Container worldstore;

    protected SoundPlay soundtrack;
    protected boolean mute = false;
   
    protected UserEntity playerEntity;
    
    protected Background bg;
   
    protected int score;
    protected Enemy enemy;
   
    public Map(String name) {

        initialiseStatic();
        initialiseNonStatic(name);

    }

    public synchronized void render(Graphics g, int delta) {

        bg.render(g, playerEntity.getXPosition(), playerEntity.getYPosition());

        worldstore.renderAll(g, delta, playerEntity.getXRenderPosition(), playerEntity.getYRenderPosition());

        Entity[] temp = new Entity[renderableEntities.size()];
        renderableEntities.toArray(temp);

        for (int i = 0; i < temp.length; i++) {
            temp[i].render(g, delta, playerEntity.getXRenderPosition(), playerEntity.getYRenderPosition());
        }

    }

    public void update() {

        MovingEntity[] temp = new MovingEntity[moveableEntities.size()];
        moveableEntities.toArray(temp);

        Collision c;

        for (int i = 0; i < temp.length; i++) {
            temp[i].calculateMovement();
            worldstore.checkCollision(temp[i]);
            for (int j = 0; j < temp.length; j++) {
                if (i != j) {
                    c = temp[j].collision(temp[i]);
                    if (c.collided) {
                        temp[i].collided(c);
                    }
                }
            }
        }

        for (int i = 0; i < temp.length; i++) {
            temp[i].move();
        }

        for (int i = 0; i < temp.length;i++) {
            if (temp[i] instanceof Enemy) {
                Enemy e = (Enemy) temp[i];
                if (e.isDead()) {
                    score += 25;
                    renderableEntities.remove(temp[i]);
                    moveableEntities.remove(temp[i]);
                }
            }
        }

    }

    public void updateWhileMenu() {
        
    }
    public double[] getPlayerState() {
        return new double[]{playerEntity.getXPosition(), playerEntity.getYPosition()};
    }
    public void resetPlayerPosition() {
        playerEntity.resetPosition();
    }
    public synchronized void reset() {
        soundtrack.close();
        String s = playerEntity.getName();
        resetNonStatic();
        initialiseNonStatic(s);
        
    }
    public boolean isDead() {
        if (playerEntity  != null) {
            return playerEntity.isDead();
        }
        return false;
    }
    public boolean isFinish()
    {
        if(playerEntity != null){
            if((int)playerEntity.getXPosition() >= 10300 && (int)playerEntity.getYPosition()>=0)
                return true;
        }
            
        return false;
    }
    protected void initialiseNonStatic(String name) {
        entities = new ArrayList<Entity>();
        renderableEntities = new ArrayList<Entity>();
        moveableEntities = new ArrayList<MovingEntity>();
        score = 0;
    }
    protected void initialiseStatic() {    
        worldstore = new Container(50);
    }
    protected void resetNonStatic() {
        renderableEntities = null;
        moveableEntities = null;
        entities = null;

        bg = null;
        playerEntity = null;
        soundtrack = null;
        score = 0;
    }

    public synchronized void addShot(GunShot shot) {
        if (!mute) {
            new SoundPlay("/sound/gunshot.mp3").play();
        }
        renderableEntities.add(shot);
        moveableEntities.add(shot);
    }

    public synchronized void removeShot(GunShot shot) {
        renderableEntities.remove(shot);
        moveableEntities.remove(shot);
    }

    public int getPlayerHp() {
        return playerEntity.getHp();
    }
    
    public int getScore(){
        return this.score;
    }
    public void mute(boolean mute) {
        this.mute = mute;
        if (mute) {
            soundtrack.close();
        }
        else {
            soundtrack.play();
        }
    }
}
